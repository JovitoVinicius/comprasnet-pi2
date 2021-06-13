package com.siasg.comprasnet.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.siasg.comprasnet.R
import org.w3c.dom.Text

private const val VIEW_TYPE_USER_MESSAGE = 1
private const val VIEW_TYPE_ASSISTANT_MESSAGE = 2

class MessageAdapter(val context: Context) :
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    private val allMessages = mutableListOf<Array<String>>()

    fun addMessage(message: String, type: String) {
        val m = arrayOf(message, type)
        allMessages.add(m)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return if (viewType == VIEW_TYPE_USER_MESSAGE) {
            UserMessageViewHolder(
                LayoutInflater.from(context).inflate(R.layout.list_enviada, parent, false)
            )
        } else {
            AssistantMessageViewHolder(
                LayoutInflater.from(context).inflate(R.layout.list_recebida, parent, false)
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        val type = allMessages[position][1]

        return if (type == "chat") {
            VIEW_TYPE_ASSISTANT_MESSAGE
        } else {
            VIEW_TYPE_USER_MESSAGE
        }
    }

    override fun getItemCount(): Int {
        return allMessages.size
    }

    override fun onBindViewHolder(holder: MessageAdapter.MessageViewHolder, position: Int) {
        val message = allMessages[position][0]

        holder.bind(message)
    }

    inner class UserMessageViewHolder(view: View) : MessageViewHolder(view) {
        private var messageText: TextView = view.findViewById(R.id.tvMessageSend)

        override fun bind(message: String) {
            messageText.text = message
        }
    }

    inner class AssistantMessageViewHolder(view: View) : MessageViewHolder(view) {
        private var messageText: TextView = view.findViewById(R.id.tvMessageBot) as TextView

        override fun bind(message: String) {
            messageText.text = message
        }
    }

    open class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //Discover import for message
        open fun bind(message: String) {}
    }
}