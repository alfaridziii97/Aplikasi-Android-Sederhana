package id.alfaridzi.dicodingsubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListReceiptAdapter(val listReceipt: ArrayList<Receipt>) : RecyclerView.Adapter<ListReceiptAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_card_receipt, viewGroup,false )
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listReceipt.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, origin, photo, howtomake, ingredients) = listReceipt[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvRank.text = origin

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, DetailFoodActivity::class.java)
            moveDetail.putExtra(DetailFoodActivity.EXTRA_ORIGIN, origin)
            moveDetail.putExtra(DetailFoodActivity.EXTRA_NAME, name)
            moveDetail.putExtra(DetailFoodActivity.EXTRA_PHOTO, photo)
            moveDetail.putExtra(DetailFoodActivity.EXTRA_INGREDIENTS, ingredients)
            moveDetail.putExtra(DetailFoodActivity.EXTRA_HOWTOMAKE, howtomake)
            mContext.startActivity(moveDetail)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvRank: TextView = itemView.findViewById(R.id.tv_item_rank)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

}