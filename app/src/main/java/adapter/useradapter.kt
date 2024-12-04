package adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import model.User


class useradapter(private var userDIPTIICT0405List: List<User>): RecyclerView.Adapter<useradapter.UserViewHolder>() {
    class UserViewHolder(private val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            binding.apply {
                displayNameTxt.text = user.displayname
                emailTxt.text = user.email
                connectedprsn.text = user.connectedprsn
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(ItemUser.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return userDIPTIICT0405List.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userDIPTIICT0405List[position]

        holder.bind(user)

    }
    fun updateData(newList: List<User>) {
        userDIPTIICT0405List = newList
        notifyDataSetChanged()
    }
}