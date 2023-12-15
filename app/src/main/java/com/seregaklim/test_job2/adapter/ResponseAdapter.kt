package com.seregaklim.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.seregaklim.data.ResponseX
import com.seregaklim.test_job2.databinding.ListResponseBinding

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


interface ResponseInteractionListener {

}

class ResponseAdapter (
    private val responseInteractionListener: ResponseInteractionListener,
) : ListAdapter<ResponseX, ResponseViewHolder>(PostDiffCallback()) {

  private var timeDataFormatter: SimpleDateFormat? = null

   init {
    timeDataFormatter = SimpleDateFormat("HH:mm", Locale.getDefault())

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseViewHolder {
        val binding =
            ListResponseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return timeDataFormatter?.let {
     ResponseViewHolder(
                binding, responseInteractionListener,
                it
            )
        }!!
    }

    override fun onBindViewHolder(holder: ResponseViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }
}

class ResponseViewHolder(
    private val binding: ListResponseBinding,
    private val responseInteractionListener: ResponseInteractionListener,
    val formatter: SimpleDateFormat,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(responseX: ResponseX) {
        binding.apply {
            tvTextAmount.text = responseX.amount
            tvTitlePayment.text = responseX.title
         getTimeDataFromMillis(responseX)
        }
    }


    private fun getTimeDataFromMillis(responseX: ResponseX) {
        val c = Calendar.getInstance()
        c.timeInMillis = responseX.created.toLong()
        val dayMonthYaer =
            DateFormat.getDateInstance(SimpleDateFormat.LONG, Locale("ru")).format(c.time)
        binding.tvTextCreated.text = dayMonthYaer
    }


}

class PostDiffCallback : DiffUtil.ItemCallback<ResponseX>() {
    override fun areItemsTheSame(oldItem: ResponseX, newItem: ResponseX): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ResponseX, newItem: ResponseX): Boolean {
        return oldItem == newItem
    }
}
