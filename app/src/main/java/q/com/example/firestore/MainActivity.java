//package q.com.example.firestore;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.EditText;
//
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.FirebaseFirestore;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class MainActivity extends AppCompatActivity {
//    DocumentReference mDocRef= FirebaseFirestore.getInstance().document("sampleData/inspiration");
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//
//    public void save(View view) {
//        EditText quote =findViewById(R.id.quote);
//        EditText  author=findViewById(R.id.author);
//        String quotetext =quote.getText().toString();
//        String authorname=author.getText().toString();
//        if(quotetext.isEmpty() || authorname.isEmpty()){return;}
//        Map<String, Object> data= new HashMap<>();
//        data.put("quote",quotetext);
//        data.put("author",authorname);
//        mDocRef.set(data).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//
//                Log.d("bhani","done");
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Log.d("bhani"," not done"+ e.toString());
//
//            }
//        });
//
//    }}
package q.com.example.firestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
 import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
  import com.google.android.gms.tasks.OnSuccessListener;
  import com.google.firebase.firestore.DocumentReference;
  import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
public class MainActivity extends AppCompatActivity {
  public Button savebtn;
  public EditText editText;
  private FirebaseFirestore mFirebasefirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        savebtn=findViewById(R.id.savebtn);
        editText=findViewById(R.id.editText);
        mFirebasefirestore=FirebaseFirestore.getInstance();

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          String Username=editText.getText().toString();
                Map<String, String> data= new HashMap<>();
      data.put("name",Username);
      data.put("image","image_link");
        mFirebasefirestore.collection("users").add(data).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {

                Log.d("bhani","done");
                Toast.makeText(MainActivity.this, "succesful", Toast.LENGTH_SHORT).show();
           }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("bhani"," not done"+ e.toString());
                Toast.makeText(MainActivity.this, " not succesful", Toast.LENGTH_SHORT).show();
            }});

            }});}}


