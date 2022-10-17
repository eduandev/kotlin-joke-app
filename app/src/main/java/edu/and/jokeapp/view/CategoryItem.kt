package edu.and.jokeapp.view

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import edu.and.jokeapp.R
import edu.and.jokeapp.model.Category

class CategoryItem(val category: Category) : Item<CategoryItem.CategoryViewHolder>() {
    class CategoryViewHolder(view:View) : GroupieViewHolder(view)

    override fun createViewHolder(itemView: View) = CategoryViewHolder(itemView)

    override fun bind(viewHolder: CategoryViewHolder, position: Int) {
        viewHolder.itemView.findViewById<TextView>(R.id.txt_category).text = category.name
        viewHolder.itemView.findViewById<LinearLayout>(R.id.container_category).setBackgroundColor(category.bgColor.toInt())

    }
    override fun getLayout() = R.layout.item_category
}