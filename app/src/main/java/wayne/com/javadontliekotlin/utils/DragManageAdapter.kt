package wayne.com.javadontliekotlin.utils

import android.content.Context
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import wayne.com.javadontliekotlin.ui.startUi.StartViewModel

class DragManageAdapter(
    private var adapter: IAdapter, context: Context, dragDirs: Int, swipeDirs: Int,
    private val viewModel: StartViewModel
) : ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs)
{

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean
    {
        adapter.swapItems(viewHolder.adapterPosition, target.adapterPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int)
    {
        viewModel.delete(adapter.getGamesAt(viewHolder.adapterPosition))
    }

}