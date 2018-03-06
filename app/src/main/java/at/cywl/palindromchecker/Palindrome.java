package at.cywl.palindromchecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Palindrome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrome);

        Button buttonCheck = (Button) findViewById(R.id.buttonCheck);

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView sourceField = (TextView) findViewById(R.id.text_palindrome);
                String text = sourceField.getText().toString();
                String status = IsPalindrome(text);

                ((TextView) findViewById(R.id.textview_status)).setText(status);
            }
        });
    }

    /**
     * Check if given string is a palindrome
     * @param target string to check
     * @return 0 if given string is a palindrome, 1 if string is null and 2 if the strins length is < 5
     */
    protected static String IsPalindrome(String target) {
        // todo: move to resources
        if (target == null) return "Given string is null!";

        if (target.length() < 5) return "Given string must have at least 5 characters!";
        boolean result = target.equals(new StringBuilder(target).reverse().toString());
        return result ? "Palindrome" : "Not a palindrome";
    }
}
