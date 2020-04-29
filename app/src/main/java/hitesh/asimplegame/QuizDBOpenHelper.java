package hitesh.asimplegame;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuizDBOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "mathsone";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "qid";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; // correct option
    private static final String KEY_OPTA = "opta"; // option a
    private static final String KEY_OPTB = "optb"; // option b
    private static final String KEY_OPTC = "optc"; // option c

    private SQLiteDatabase database;

    public QuizDBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        database = db;

        String sql="CREATE TABLE IF NOT EXISTS " + TABLE_QUEST+ " ( "
                    + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                    + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                    + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
            addQuestion();
            db.execSQL(sql);

           //db.close();
    }

    private void addQuestion() {
            Question q1 = new Question("5+2 = ?", "7", "8", "6", "7");
            addQuestion(q1);
            Question q2 = new Question("2+18 = ?", "18", "19", "20", "20");
            addQuestion(q2);
            Question q3 = new Question("10-3 = ?", "6", "7", "8", "7");
            addQuestion(q3);
            Question q4 = new Question("5+7 = ?", "12", "13", "14", "12");
            addQuestion(q4);
            Question q5 = new Question("3-1 = ?", "1", "3", "2", "2");
            addQuestion(q5);
            Question q6 = new Question("0+1 = ?", "1", "0", "10", "1");
            addQuestion(q6);
            Question q7 = new Question("9-9 = ?", "0", "9", "1", "0");
            addQuestion(q7) ;
            Question q8 = new Question("3+6 = ?", "8", "7", "9", "9");
            addQuestion(q8);
            Question q9 = new Question("1+5 = ?", "6", "7", "5", "6");
            addQuestion(q9);
            Question q10 = new Question("7-5 = ?", "3", "2", "6", "2");
            addQuestion(q10);
            Question q11 = new Question("7-2 = ?", "7", "6", "5", "5");
            addQuestion(q11);
            Question q12 = new Question("3+5 = ?", "8", "7", "5", "8");
            addQuestion(q12);
            Question q13 = new Question("0+6 = ?", "7", "6", "5", "6");
            addQuestion(q13);
            Question q14 = new Question("12-10 = ?", "1", "2", "3", "2");
            addQuestion(q14);
            Question q15 = new Question("12+2 = ?", "14", "15", "16", "14");
            addQuestion(q15);
            Question q16 = new Question("2-1 = ?", "2", "1", "0", "1");
            addQuestion(q16);
            Question q17 = new Question("6-6 = ?", "6", "12", "0", "0");
            addQuestion(q17);
            Question q18 = new Question("5-1 = ?", "4", "3", "2", "4");
            addQuestion(q18);
            Question q19 = new Question("4+2 = ?", "6", "7", "5", "6");
            addQuestion(q19);
            Question q20 = new Question("5+1 = ?", "6", "7", "5", "6");
            addQuestion(q20);
            Question q21 = new Question("5-4 = ?", "5", "4", "1", "1");
            addQuestion(q21);
            Question q41 = new Question("5-4 = ?", "5", "4", "1", "1");
            addQuestion(q41);
            Question q61 = new Question("5-4 = ?", "5", "4", "1", "1");
            addQuestion(q61);
            Question q81 = new Question("5-4 = ?", "5", "4", "1", "1");
            addQuestion(q81);
            Question q101 = new Question("5-4 = ?", "5", "4", "1", "1");
            addQuestion(q101);
            Question q121 = new Question("5-4 = ?", "5", "4", "1", "1");
            addQuestion(q121);
            Question q141 = new Question("5-4 = ?", "5", "4", "1", "1");
            addQuestion(q141);
            Question q161 = new Question("5-4 = ?", "5", "4", "1", "1");
            addQuestion(q161);
            Question q181 = new Question("5-4 = ?", "5", "4", "1", "1");
            addQuestion(q181);
            Question q201 = new Question("5-4 = ?", "5", "4", "1", "1");
            addQuestion(q201);
            Question q221 = new Question("5-4 = ?", "5", "4", "1", "1");
            addQuestion(q221);
            Question q241 = new Question("5-4 = ?", "5", "4", "1", "1");
            addQuestion(q241);
            Question q261 = new Question("5-4 = ?", "5", "4", "1", "1");
            addQuestion(q261);
            Question q281 = new Question("5-4 = ?", "5", "4", "1", "1");
            addQuestion(q281);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }

    // Adding new question
    public void addQuestion(Question quest) {
        // SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserting Row
        database.insert(TABLE_QUEST, null, values);
    }

    public List<Question> getAllQuestions(int n) {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
//        if (cursor.moveToPosition(n)) {
//            do {
//                Question quest = new Question();
//                quest.setID(cursor.getInt(0));
//                quest.setQUESTION(cursor.getString(1));
//                quest.setANSWER(cursor.getString(2));
//                quest.setOPTA(cursor.getString(3));
//                quest.setOPTB(cursor.getString(4));
//                quest.setOPTC(cursor.getString(5));
//
//                quesList.add(quest);
//            } while (cursor.moveToNext());
//        }

        if(cursor.moveToPosition(n)){
            for(int i=0;i<20;i++){
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));

                quesList.add(quest);
                cursor.moveToNext();
            }
        }

        // return quest list
        return quesList;
    }
}
//stage11->1
//12->21
//13->41
//14->61
//15->81
//21->101
//22->121
//23->141
//24->161
//25->181
//31->201
//32->221
//33->241
//34->261
//35->281
