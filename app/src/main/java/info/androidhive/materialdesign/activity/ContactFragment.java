package info.androidhive.materialdesign.activity;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.database.CountryDb;


public class ContactFragment extends Fragment {
    private CountryDb dbHelper;
    ListView listView;

    public ContactFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);
        listView = (ListView) rootView.findViewById(R.id.listViewContacts);
        return rootView;
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        dbHelper = new CountryDb(getActivity());
        dbHelper.open();

        // Clean all data
        dbHelper.deleteAllMyAddress();
        // Add some data
        dbHelper.insertSomeMyAddress();

        // Generate ListView from SQLite Database
        displayListView();
    }

    private void displayListView() {

        Cursor cursor = dbHelper.fetchAllMyAddress();

        // the desired columns to be bound
        String[] columns = new String[] { CountryDb.KEY_CODE, CountryDb.KEY_NAME, CountryDb.KEY_CONTINENT };

        // the XML defined views which the data will be bound to
        int[] to = new int[] { R.id.code, R.id.name, R.id.continent };

        // create the adapter using the cursor pointing to the desired data
        // as well as the layout information
        MyCursorAdapterMyAddresses dataAdapter = new MyCursorAdapterMyAddresses(getActivity(), R.layout.list_row,
                cursor, columns, to, 0);

        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);

    }

    // extend the SimpleCursorAdapter to create a custom class where we
    // can override the getView to change the row colors
    private class MyCursorAdapterMyAddresses extends SimpleCursorAdapter {

        public MyCursorAdapterMyAddresses(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
            super(context, layout, c, from, to, flags);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // get reference to the row
            View view = super.getView(position, convertView, parent);
            // check for odd or even to set alternate colors to the row
            // background
            if (position % 2 == 0) {
                view.setBackgroundColor(Color.rgb(238, 233, 233));
            } else {
                view.setBackgroundColor(Color.rgb(255, 255, 255));
            }
            return view;
        }

    }

}
