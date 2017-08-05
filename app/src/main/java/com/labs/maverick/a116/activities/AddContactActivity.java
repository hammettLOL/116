package com.labs.maverick.a116.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.labs.maverick.a116.R;
import com.labs.maverick.a116.adapters.ContactsAdapter;
import com.labs.maverick.a116.model.Contact;

import java.util.List;

public class AddContactActivity extends AppCompatActivity {

    private Button mcontinuarButton;
    private Button mcontactsButton;
    private static final int REQUEST_CODE_PICK_CONTACTS = 1;
    private Uri uriContact;
    private String contactID;     // contacts unique ID
    private static final String TAG = AddContactActivity.class.getSimpleName();
    private RecyclerView mcontactRecycleView;
    private ContactsAdapter contactsAdapter;
    private List<Contact> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        bindUI();
        contactsAdapter = new ContactsAdapter();
        showRecycleView();
        mcontinuarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMain();
            }
        });
        mcontactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToContacts();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_PICK_CONTACTS && resultCode == RESULT_OK) {
            Log.d(TAG, "Response: " + data.toString());
            uriContact = data.getData();
           String name = retrieveContactName();
           String phone = retrieveContactNumber();

           Contact contact = new Contact(name,phone);
           contact.save();

        }
    }

    @Override
    protected void onResume() {
        super.onResume();

            updateData();


    }

    private void showRecycleView(){
        if(Contact.listAll(Contact.class) != null) {

            contactsAdapter.setContactList(Contact.listAll(Contact.class));
            mcontactRecycleView.setAdapter(contactsAdapter);
            mcontactRecycleView.setLayoutManager(new LinearLayoutManager(this));

        }
    }

    private void updateData(){
        ((ContactsAdapter)mcontactRecycleView.getAdapter()).setContactList(Contact.listAll(Contact.class));
        mcontactRecycleView.getAdapter().notifyDataSetChanged();
    }
    public void bindUI(){
        mcontinuarButton = findViewById(R.id.continuarButton);
        mcontactsButton = findViewById(R.id.contactsButton);
        mcontactRecycleView = findViewById(R.id.contactsRecycleView);
    }
    public void goToContacts(){
        startActivityForResult(new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI), REQUEST_CODE_PICK_CONTACTS);

    }
    public void goToMain(){
        Contact.deleteAll(Contact.class);
        Intent intent = new Intent(AddContactActivity.this, MainActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    public String retrieveContactName() {

        String contactName = null;

        // querying contact data store
        Cursor cursor = getContentResolver().query(uriContact, null, null, null, null);

        if (cursor.moveToFirst()) {

            // DISPLAY_NAME = The display name for the contact.
            // HAS_PHONE_NUMBER =   An indicator of whether this contact has at least one phone number.

            contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
        }

        cursor.close();

        return contactName;

    }

    public String retrieveContactNumber() {

        String contactNumber = null;

        // getting contacts ID
        Cursor cursorID = getContentResolver().query(uriContact,
                new String[]{ContactsContract.Contacts._ID},
                null, null, null);

        if (cursorID.moveToFirst()) {

            contactID = cursorID.getString(cursorID.getColumnIndex(ContactsContract.Contacts._ID));
        }

        cursorID.close();

        Log.d(TAG, "Contact ID: " + contactID);

        // Using the contact ID now we will get contact phone number
        Cursor cursorPhone = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER},

                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ? AND " +
                        ContactsContract.CommonDataKinds.Phone.TYPE + " = " +
                        ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE,

                new String[]{contactID},
                null);

        if (cursorPhone.moveToFirst()) {
            contactNumber = cursorPhone.getString(cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
        }

        cursorPhone.close();

        return contactNumber;
    }

}
