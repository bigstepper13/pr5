package com.example.pr5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.ArrayList;

public class MainFragment extends Fragment {
    public MainFragment() {super(R.layout.fragment_main);}
    Button main_fragment_button1;
    EditText main_fragment_edit_text;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        main_fragment_button1 = (Button) getActivity().findViewById(R.id.button);
        main_fragment_edit_text = (EditText) getActivity().findViewById(R.id.fragment_main_edit_text);

        main_fragment_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = main_fragment_edit_text.getText().toString();
                NavController navController = Navigation.findNavController(view);

                if (!date.isEmpty()) {
                    ArrayList<String> Data =  new ArrayList<String>();
                    Data.add(date);

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("name",  Data);
                    navController.navigate(R.id.action_mainFragment_to_firstFragment, bundle);
                } else {
                    main_fragment_edit_text.setText("");
                    main_fragment_edit_text.setHint(getResources().getString(R.string.name_2));
                }
            }
        });
    }
    public static boolean isNumber(String string_num) {
        try {
            Integer.parseInt(string_num);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
