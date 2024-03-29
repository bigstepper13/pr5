package com.example.pr5;

import static com.example.pr5.MainFragment.isNumber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FirstFragment extends Fragment {
    public FirstFragment() {
        super(R.layout.fragment_first);
    }

    Button first_fragment_button1;
    TextView first_fragment_text_view;
    EditText first_fragment_edit_text;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        first_fragment_button1 = (Button) getActivity().findViewById(R.id.fragment_first_button);
        first_fragment_text_view = (TextView) getActivity().findViewById(R.id.fragment_first_text_view2);
        first_fragment_edit_text = (EditText) getActivity().findViewById(R.id.fragment_first_edit_text);

        Bundle bundle = this.getArguments();
        ArrayList Name = bundle.getStringArrayList("name");
        String name = Name.get(0).toString();

        first_fragment_text_view.setText(name);

        first_fragment_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = first_fragment_edit_text.getText().toString();

                ArrayList<String> Name =  new ArrayList<String>();
                Name.add(name);
                Name.add(amount);

                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name&team",  Name);
                Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment, bundle);
                first_fragment_edit_text.setText("");
                first_fragment_edit_text.setHint(getResources().getString(R.string.name_2));
            }
        });
    }
}
