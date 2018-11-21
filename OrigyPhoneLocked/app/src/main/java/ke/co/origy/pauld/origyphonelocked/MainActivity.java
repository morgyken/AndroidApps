package ke.co.origy.pauld.origyphonelocked;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private Button btnChat;
    private EditText post;
    private EditText smsDisplay;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btnChat = (Button) findViewById(R.id.btnChat);
        post = (EditText) findViewById(R.id.etPost);
        smsDisplay = (EditText) findViewById(R.id.smsDisplay);

        // Request focus and show soft keyboard automatically

        btnChat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // unlock home button and then screen on button press
                String newValue = post.getText().toString().trim();
                myRef.setValue(newValue);

                // Read from the database
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        String value = dataSnapshot.getValue(String.class);
                        smsDisplay.setText(value);
                        //Log.d(TAG, "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        smsDisplay.setText("Failed to read value.");
                        //Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });

            }
        });
    }

}
