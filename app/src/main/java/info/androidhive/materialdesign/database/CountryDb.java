package info.androidhive.materialdesign.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CountryDb {

	public static final String KEY_ROWID = "_id";
	public static final String KEY_CODE = "code";
	public static final String KEY_NAME = "name";
	public static final String KEY_CONTINENT = "continent";

	private static final String TAG = "CountriesDbAdapter";
	private DatabaseHelper mDbHelper;
	private SQLiteDatabase mDb;

	private static final String DATABASE_NAME = "World";
	private static final String SQLITE_TABLE = "Country";
	private static final String SQLITE_TABLE2 = "disclamair";
	private static final String SQLITE_TABLE3 = "terms";
	private static final String SQLITE_TABLE4 = "myaddress";
	private static final String SQLITE_TABLE5 = "whofoundme";
	private static final int DATABASE_VERSION = 1;

	private final Context mCtx;

	private static final String DATABASE_CREATE = "CREATE TABLE if not exists " + SQLITE_TABLE + " (" + KEY_ROWID
			+ " integer PRIMARY KEY autoincrement," + KEY_CODE + "," + KEY_NAME + "," + KEY_CONTINENT + ","
			+ " UNIQUE (" + KEY_CODE + "));";
	private static final String DATABASE_CREATE2 = "CREATE TABLE if not exists " + SQLITE_TABLE2 + " (" + KEY_ROWID
			+ " integer PRIMARY KEY autoincrement," + KEY_CODE + "," + KEY_NAME + "," + KEY_CONTINENT + ","
			+ " UNIQUE (" + KEY_CODE + "));";
	private static final String DATABASE_CREATE3 = "CREATE TABLE if not exists " + SQLITE_TABLE3 + " (" + KEY_ROWID
			+ " integer PRIMARY KEY autoincrement," + KEY_CODE + "," + KEY_NAME + "," + KEY_CONTINENT + ","
			+ " UNIQUE (" + KEY_CODE + "));";
	private static final String DATABASE_CREATE4 = "CREATE TABLE if not exists " + SQLITE_TABLE4 + " (" + KEY_ROWID
			+ " integer PRIMARY KEY autoincrement," + KEY_CODE + "," + KEY_NAME + "," + KEY_CONTINENT + ","
			+ " UNIQUE (" + KEY_CODE + "));";
	private static final String DATABASE_CREATE5 = "CREATE TABLE if not exists " + SQLITE_TABLE5 + " (" + KEY_ROWID
			+ " integer PRIMARY KEY autoincrement," + KEY_CODE + "," + KEY_NAME + "," + KEY_CONTINENT + ","
			+ " UNIQUE (" + KEY_CODE + "));";

	private static class DatabaseHelper extends SQLiteOpenHelper {

		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			Log.w(TAG, DATABASE_CREATE);
			db.execSQL(DATABASE_CREATE);
			db.execSQL(DATABASE_CREATE2);
			db.execSQL(DATABASE_CREATE3);
			db.execSQL(DATABASE_CREATE4);
			db.execSQL(DATABASE_CREATE5);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion
					+ ", which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS " + SQLITE_TABLE);
			onCreate(db);
		}
	}

	public CountryDb(Context ctx) {
		this.mCtx = ctx;
	}

	public CountryDb open() throws SQLException {
		mDbHelper = new DatabaseHelper(mCtx);
		mDb = mDbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		if (mDbHelper != null) {
			mDbHelper.close();
		}
	}

	public long createCountry(String code, String name, String continent) {

		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_CODE, code);
		initialValues.put(KEY_NAME, name);
		initialValues.put(KEY_CONTINENT, continent);

		return mDb.insert(SQLITE_TABLE, null, initialValues);
	}

	public long createDisclamair(String code, String name, String continent) {

		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_CODE, code);
		initialValues.put(KEY_NAME, name);
		initialValues.put(KEY_CONTINENT, continent);

		return mDb.insert(SQLITE_TABLE2, null, initialValues);
	}

	public long createTerms(String code, String name, String continent) {

		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_CODE, code);
		initialValues.put(KEY_NAME, name);
		initialValues.put(KEY_CONTINENT, continent);

		return mDb.insert(SQLITE_TABLE3, null, initialValues);
	}

	public long createMyAddress(String code, String name, String continent) {

		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_CODE, code);
		initialValues.put(KEY_NAME, name);
		initialValues.put(KEY_CONTINENT, continent);

		return mDb.insert(SQLITE_TABLE4, null, initialValues);
	}

	public long createWhoFoundMe(String code, String name, String continent) {

		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_CODE, code);
		initialValues.put(KEY_NAME, name);
		initialValues.put(KEY_CONTINENT, continent);

		return mDb.insert(SQLITE_TABLE5, null, initialValues);
	}

	public boolean deleteAllCountries() {

		int doneDelete = 0;
		doneDelete = mDb.delete(SQLITE_TABLE, null, null);

		Log.w(TAG, Integer.toString(doneDelete));
		return doneDelete > 0;

	}

	public boolean deleteAllDisclamairs() {

		int doneDelete = 0;
		doneDelete = mDb.delete(SQLITE_TABLE2, null, null);
		Log.w(TAG, Integer.toString(doneDelete));
		return doneDelete > 0;

	}

	public boolean deleteAllTerms() {

		int doneDelete = 0;
		doneDelete = mDb.delete(SQLITE_TABLE3, null, null);
		Log.w(TAG, Integer.toString(doneDelete));
		return doneDelete > 0;

	}

	public boolean deleteAllMyAddress() {

		int doneDelete = 0;
		doneDelete = mDb.delete(SQLITE_TABLE4, null, null);
		Log.w(TAG, Integer.toString(doneDelete));
		return doneDelete > 0;

	}

	public boolean deleteAllWhoFounMe() {

		int doneDelete = 0;
		doneDelete = mDb.delete(SQLITE_TABLE5, null, null);
		Log.w(TAG, Integer.toString(doneDelete));
		return doneDelete > 0;

	}

	public Cursor fetchAllCountries() {

		Cursor mCursor = mDb.query(SQLITE_TABLE, new String[] { KEY_ROWID, KEY_CODE, KEY_NAME, KEY_CONTINENT }, null,
				null, null, null, null);

		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	public Cursor fetchAllDisclamairs() {

		Cursor mCursor = mDb.query(SQLITE_TABLE2, new String[] { KEY_ROWID, KEY_CODE, KEY_NAME, KEY_CONTINENT }, null,
				null, null, null, null);

		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	public Cursor fetchAllTerms() {

		Cursor mCursor = mDb.query(SQLITE_TABLE3, new String[] { KEY_ROWID, KEY_CODE, KEY_NAME, KEY_CONTINENT }, null,
				null, null, null, null);

		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	public Cursor fetchAllMyAddress() {

		Cursor mCursor = mDb.query(SQLITE_TABLE4, new String[] { KEY_ROWID, KEY_CODE, KEY_NAME, KEY_CONTINENT }, null,
				null, null, null, null);

		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	public Cursor fetchAllWhoFoundMe() {

		Cursor mCursor = mDb.query(SQLITE_TABLE5, new String[] { KEY_ROWID, KEY_CODE, KEY_NAME, KEY_CONTINENT }, null,
				null, null, null, null);

		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	public void insertSomeCountries() {

		createCountry("AFG", "Afghanistan", "Asia");
		createCountry("CHN", "China", "Asia");
		createCountry("ALB", "Albania", "Europe");
		createCountry("DZA", "Algeria", "Africa");
		createCountry("ASM", "American Samoa", "Oceania");
		createCountry("AND", "Andorra", "Europe");
		createCountry("AGO", "Angola", "Africa");
		createCountry("AIA", "Anguilla", "North America");
		createCountry("USA", "United States", "North America");
		createCountry("CAN", "Canada", "North America");

	}

	// DISCLAMAIRS
	public void insertSomeDisclamairs() {

		createDisclamair("1", "1",
				"The data in this application is given by the user directly. We are not responsible for the data discrepancies");
		createDisclamair("2", "2", "Order of data fetch might change time to time");

	}

	// TERMS AND CONDITIONS
	public void insertSomeTerms() {

		createTerms("1", "1",
				"If the address is not find any time for a year, the address will be consider as changed and will be deleted automatically");
		createTerms("2", "2",
				"If the user is not log in for a year, the user account will be consider as dead account and will be deleted automatically");
		createTerms("2", "2", "User can view only 180 days searched user history only");

	}

	// TERMS AND CONDITIONS
	public void insertSomeMyAddress() {

		createMyAddress("OWXCFC2S15", "David", "NO:19, old murugan talkies first street palanganatham madurai");
		createMyAddress("7KXJBXRNO1", "Kevin",
				"686, Karuna Trust Building,Between 38th and 39th Cross, 16th Main, Jayanagar 4th T Block,Near Sobha Opal Apartments, Bengaluru, Karnataka 560041");
		createMyAddress("7KXJBXRNO2", "Mano",
				"686, Karuna Trust Building,Between 38th and 39th Cross, 16th Main, Jayanagar 4th T Block,Near Sobha Opal Apartments, Bengaluru, Karnataka 560041");
		createMyAddress("7KXJBXRNO3", "Charles",
				"686, Karuna Trust Building,Between 38th and 39th Cross, 16th Main, Jayanagar 4th T Block,Near Sobha Opal Apartments, Bengaluru, Karnataka 560041");
		createMyAddress("7KXJBXRNO4", "Christopher",
				"686, Karuna Trust Building,Between 38th and 39th Cross, 16th Main, Jayanagar 4th T Block,Near Sobha Opal Apartments, Bengaluru, Karnataka 560041");
		createMyAddress("7KXJBXRNO5", "Pavan",
				"686, Karuna Trust Building,Between 38th and 39th Cross, 16th Main, Jayanagar 4th T Block,Near Sobha Opal Apartments, Bengaluru, Karnataka 560041");
		createMyAddress("OWXCFC2S151", "David", "NO:19, old murugan talkies first street palanganatham madurai");
		createMyAddress("7KXJBXRNO12", "Kevin",
				"686, Karuna Trust Building,Between 38th and 39th Cross, 16th Main, Jayanagar 4th T Block,Near Sobha Opal Apartments, Bengaluru, Karnataka 560041");
		createMyAddress("7KXJBXRNO23", "Mano",
				"686, Karuna Trust Building,Between 38th and 39th Cross, 16th Main, Jayanagar 4th T Block,Near Sobha Opal Apartments, Bengaluru, Karnataka 560041");
		createMyAddress("7KXJBXRNO34", "Charles",
				"686, Karuna Trust Building,Between 38th and 39th Cross, 16th Main, Jayanagar 4th T Block,Near Sobha Opal Apartments, Bengaluru, Karnataka 560041");
		createMyAddress("7KXJBXRNO45", "Christopher",
				"686, Karuna Trust Building,Between 38th and 39th Cross, 16th Main, Jayanagar 4th T Block,Near Sobha Opal Apartments, Bengaluru, Karnataka 560041");
		createMyAddress("7KXJBXRNO56", "Pavan",
				"686, Karuna Trust Building,Between 38th and 39th Cross, 16th Main, Jayanagar 4th T Block,Near Sobha Opal Apartments, Bengaluru, Karnataka 560041");

	}

	// TERMS AND CONDITIONS
	public void insertSomeWhoFoundMe() {

		createWhoFoundMe("OWXCFC2S15", "Home", "NO:19, old murugan talkies first street palanganatham madurai");
		createWhoFoundMe("7KXJBXRNO1", "Office",
				"686, Karuna Trust Building,Between 38th and 39th Cross, 16th Main, Jayanagar 4th T Block,Near Sobha Opal Apartments, Bengaluru, Karnataka 560041");
		createWhoFoundMe("7KXJBXRNO2", "Office",
				"686, Karuna Trust Building,Between 38th and 39th Cross, 16th Main, Jayanagar 4th T Block,Near Sobha Opal Apartments, Bengaluru, Karnataka 560041");
		createWhoFoundMe("7KXJBXRNO3", "Office",
				"686, Karuna Trust Building,Between 38th and 39th Cross, 16th Main, Jayanagar 4th T Block,Near Sobha Opal Apartments, Bengaluru, Karnataka 560041");
		createWhoFoundMe("7KXJBXRNO4", "Office",
				"686, Karuna Trust Building,Between 38th and 39th Cross, 16th Main, Jayanagar 4th T Block,Near Sobha Opal Apartments, Bengaluru, Karnataka 560041");
		createWhoFoundMe("7KXJBXRNO5", "Office",
				"686, Karuna Trust Building,Between 38th and 39th Cross, 16th Main, Jayanagar 4th T Block,Near Sobha Opal Apartments, Bengaluru, Karnataka 560041");

	}

}
