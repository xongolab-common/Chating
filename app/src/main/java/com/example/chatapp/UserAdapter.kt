package com.example.chatapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.databinding.RawUserBinding


class UserAdapter(val context: Context, private val userList: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.ChatViewHolder>() {

    inner class ChatViewHolder(var binding: RawUserBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val binding = RawUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val user = userList[position]

        holder.binding.apply {
            tvUserName.text = user.name
            tvEmail.text = user.email

            llUser.setOnClickListener {
                val intent = Intent(context, ChatActivity::class.java)
                intent.putExtra("name", user.name)
                intent.putExtra("uid", user.uid)
                context.startActivity(intent)
            }

        }
    }

    override fun getItemCount(): Int = userList.size
}