package jinro.activity;

import jinro.adapter.MessageListAdapter;
import sample.jinro.R;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class NightFragmentMessage extends Fragment {
	private ListView messageList;
	private MessageListAdapter adapter;
	private EditText messageArea;
	private Button sendButton;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.night_fragment_message,
				container, false);
		messageList = (ListView) view.findViewById(R.id.night_message_list);
		//TODO listなに渡す？
		//adapter = new MessageListAdapter(getActivity(), R.id.night_message_list, null);
		//messageList.setAdapter(adapter);

		messageArea = (EditText) view.findViewById(R.id.message_box);
		messageArea.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
					hideKeyBoard(v);
					sendMessage();
				}
				return true;
			}
		});
		messageArea.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,int after) {	}
			@Override
			public void afterTextChanged(Editable s) {
				if(messageArea.length() == 0)
					sendButton.setEnabled(false);
				else
					sendButton.setEnabled(true);
			}
		});
		sendButton = (Button) view.findViewById(R.id.message_send_button);
		sendButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				hideKeyBoard(v);
				sendMessage();
			}
		});
		sendButton.setEnabled(false);
		return view;
	}

	private void hideKeyBoard(View v){
		InputMethodManager imm = (InputMethodManager) getActivity()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(v.getWindowToken(),
				InputMethodManager.HIDE_NOT_ALWAYS);
	}
	private void sendMessage(){
		//TODO sendmessage
		messageArea.getEditableText().clear();
	}

}
