package edu.nd.mlab.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.thirdparty.javascript.rhino.head.ast.FunctionNode.Form;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;

public class uploader extends Composite {

	@UiField
	FormPanel form;
	
	@UiField
	Button uploadButton;
	
	
	@UiField
	FileUpload fileSelector;
	
	
	private static uploaderUiBinder uiBinder = GWT.create(uploaderUiBinder.class);

	interface uploaderUiBinder extends UiBinder<Widget, uploader> {
	}

	public uploader() {
		initWidget(uiBinder.createAndBindUi(this));
		
		
		
		form.setAction("/fileuploadtest/upload");
		form.setEncoding(FormPanel.ENCODING_MULTIPART);
		form.setMethod(FormPanel.METHOD_POST);

		
		
		fileSelector.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				// TODO Auto-generated method stub
				Window.alert("new file has been selected");
			}
		});
		
		
		form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
			
			@Override
			public void onSubmitComplete(SubmitCompleteEvent event) {
				// TODO Auto-generated method stub
				Window.alert("recieve response from server : " + event.getResults());
			}
		});
		
		
		uploadButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Window.alert("button clicked.....");
				form.submit();
			}
		});
	}

}
