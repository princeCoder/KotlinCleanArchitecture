package com.prinzlycoder.androidappconcepts.presentation.list

import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

open class ListAdapter<T : ListItem> : RecyclerView.Adapter<ListViewHolder<T>>() {

    private var isAttached = true
    private var elements: ArrayList<T> = ArrayList()
    var delegateManager: DelegateManager<T> = DelegateManager(this)
    private var selectedPosition = RecyclerView.NO_POSITION

    open fun setItems(data: List<T>) {
        elements = ArrayList(data)
        notifyDataSetChanged()
    }

    fun getItems() = elements

    open fun updateItem(item: T) {
        val position = elements.indexOf(item)
        if (position == -1) {
            throw IllegalArgumentException("Position was " + position + " but array length was only " + elements.size)
        }
        elements[position] = item
        notifyItemChanged(position)
    }

    open fun updateItemAt(item: T, position: Int) {
        if (position < 0 || position >= elements.size) {
            throw IllegalArgumentException("Position was " + position + " but array length was only " + elements.size)
        }
        elements[position] = item
        notifyItemChanged(position)
    }

    fun addItem(item: T) {
        elements.add(item)
        notifyItemInserted(elements.size - 1)
    }

    fun resetItem(position: Int) {
        if (selectedPosition != RecyclerView.NO_POSITION) {
            notifyItemChanged(selectedPosition)
        }
        selectedPosition = position
        notifyItemChanged(selectedPosition)
    }

    fun addItemAt(item: T, position: Int) {
        if (position < 0 || position >= elements.size) {
            throw IllegalArgumentException("Position was " + position + " but array length was only " + elements.size)
        }
        elements.add(position, item)
        notifyItemInserted(position)
    }

    fun getItemAt(position: Int): T {
        return if (position < elements.size && position >= 0) {
            elements[position]
        } else {
            throw IllegalArgumentException("Item position should be from 0 to elements size")
        }
    }

    fun removeItem(item: T) {
        val position = elements.indexOf(item)
        if (position >= 0 && position < elements.size) {
            elements.remove(item)
            notifyItemRemoved(position)
        }
    }

    fun removeItemAt(position: Int) {
        if (position >= 0 && position < elements.size) {
            elements.removeAt(position)
            notifyItemRemoved(position)
        } else {
            throw IllegalArgumentException("Item position should be from 0 to elements size")
        }
    }

    fun clear() {
        elements.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return elements.size
    }

    override fun onBindViewHolder(holder: ListViewHolder<T>, position: Int) {
        delegateManager.onBindViewHolder(holder, elements[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder<T> {
        return delegateManager.onCreateViewHolder(parent, viewType)
    }

    override fun getItemViewType(position: Int): Int {
        return delegateManager.getViewType(elements[position])
    }

    override fun onViewDetachedFromWindow(holder: ListViewHolder<T>) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.clearAnimation()
    }

    override fun onAttachedToRecyclerView(@NonNull recyclerView: RecyclerView) {

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(@NonNull recyclerView: RecyclerView, newState: Int) {
                isAttached = false
                super.onScrollStateChanged(recyclerView, newState)
            }
        })

        super.onAttachedToRecyclerView(recyclerView)
    }
}
