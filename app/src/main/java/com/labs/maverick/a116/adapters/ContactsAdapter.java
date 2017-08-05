package com.labs.maverick.a116.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.labs.maverick.a116.R;
import com.labs.maverick.a116.model.Contact;

import java.util.List;

/**
 * Created by Maverick on 4/08/2017.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    private List<Contact> contactList;
    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_view_contactos,parent,false));
    }

    @Override
    public void onBindViewHolder(ContactsAdapter.ViewHolder holder, int position) {
    holder.namecontactTextView.setText(contactList.get(position).getName());
    holder.phonecontactTextView.setText(contactList.get(position).getPhone());
    holder.clearImageButton.setImageResource(R.drawable.ic_clear_white_24dp);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
    public List<Contact> getContactList(){
        return contactList;
    }
    public void setContactList(List<Contact> contactList){
        this.contactList = contactList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView namecontactTextView;
        private TextView phonecontactTextView;
        private ImageButton clearImageButton;
        public ViewHolder(View itemView) {
            super(itemView);
            namecontactTextView = itemView.findViewById(R.id.namecontactTextView);
            phonecontactTextView = itemView.findViewById(R.id.phonecontactTextView);
            clearImageButton = itemView.findViewById(R.id.clearImageButton);
        }
    }
}
