package com.example.chatapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.databinding.RawChatBinding
import com.google.firebase.auth.FirebaseAuth


class MessageAdapter(val context: Context, val messagesList: ArrayList<Message>) :
    RecyclerView.Adapter<MessageAdapter.ChatViewHolder>() {

    inner class ChatViewHolder(var binding: RawChatBinding) : RecyclerView.ViewHolder(binding.root) {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val binding = RawChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return messagesList.size
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val currentMessage = messagesList[position]

        val currentUserId = FirebaseAuth.getInstance().currentUser?.uid

        holder.binding.apply {
            if (currentUserId == currentMessage.senderId) {
                llSend.visibility = View.VISIBLE
                llReceiver.visibility = View.GONE
                tvSend.text = currentMessage.message
            } else {
                llSend.visibility = View.GONE
                llReceiver.visibility = View.VISIBLE
                tvReceiver.text = currentMessage.message
            }
        }

    }
}
