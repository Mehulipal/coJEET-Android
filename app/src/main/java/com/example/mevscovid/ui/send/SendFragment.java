package com.example.mevscovid.ui.send;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mevscovid.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage;
import com.google.firebase.ml.naturallanguage.smartreply.FirebaseSmartReply;
import com.google.firebase.ml.naturallanguage.smartreply.FirebaseTextMessage;
import com.google.firebase.ml.naturallanguage.smartreply.SmartReplySuggestion;
import com.google.firebase.ml.naturallanguage.smartreply.SmartReplySuggestionResult;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SendFragment extends Fragment {

    private SendViewModel sendViewModel;
    private final String REMOTE_USER_ID = UUID.randomUUID().toString();
    private List<FirebaseTextMessage> chatHistory = new ArrayList<>();
    private EditText edt;
    private TextView txt;
    private Button Btn;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
      //  sendViewModel =
        //        ViewModelProviders.of(this).get(SendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_send, container, false);
        /**final TextView textView = root.findViewById(R.id.text_send);
        sendViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        }); **/

            edt = root.findViewById(R.id.edt);
            txt = root.findViewById(R.id.txt);
            Btn = root.findViewById(R.id.btn);

            Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    txt.setText(null);
                    String text = edt.getText().toString().trim();
                    chatHistory.add(FirebaseTextMessage.createForRemoteUser(text, System.currentTimeMillis(), REMOTE_USER_ID));
                    if (v.getId() == R.id.btn) {
                        suggestReplyingMessages(chatHistory);
                    }
                }
            });
            return root;
        }

        private void suggestReplyingMessages(List<FirebaseTextMessage> chat) {
            FirebaseSmartReply smartReply = FirebaseNaturalLanguage.getInstance().getSmartReply();
            smartReply.suggestReplies(chat).addOnSuccessListener(new OnSuccessListener<SmartReplySuggestionResult>() {
                @Override
                public void onSuccess(SmartReplySuggestionResult result) {
                    if (result.getStatus() == SmartReplySuggestionResult.STATUS_NOT_SUPPORTED_LANGUAGE) {
                        txt.setText(getString(R.string.smart_reply_error));
                    } else if (result.getStatus() == SmartReplySuggestionResult.STATUS_SUCCESS) {
                        for (SmartReplySuggestion suggestion : result.getSuggestions()) {
                            txt.append(suggestion.getText());
                            txt.append("\n");
                        }
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    txt.setText(e.getMessage());
                }
            });
        }
    }