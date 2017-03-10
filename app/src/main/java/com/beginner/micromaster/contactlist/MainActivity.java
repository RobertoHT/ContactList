package com.beginner.micromaster.contactlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.beginner.micromaster.contactlist.adapters.ContactListAdapter;
import com.beginner.micromaster.contactlist.models.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ContactListAdapter adapter;
    private ArrayList<Contact> arrayOfUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayOfUsers = getContactsFromDB();
        adapter = new ContactListAdapter(this, arrayOfUsers);

        ListView listView = (ListView) findViewById(R.id.contact_list_view);
        listView.setAdapter(adapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent detailIntent = new Intent(getApplicationContext(), DetailActivity.class);
                detailIntent.putExtra("contact",arrayOfUsers.get(position));
                startActivity(detailIntent);
            }
        });

        final Button button = (Button) findViewById(R.id.add_new_contact);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent downloadIntent = new Intent(getApplicationContext(), AddNewContactActivity.class);
                startActivity(downloadIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        arrayOfUsers = getContactsFromDB();
        adapter.notifyDataSetChanged();
    }

    private ArrayList<Contact> getContactsFromDB() {
        return new ArrayList<>(Contact.getAll());
    }

}
