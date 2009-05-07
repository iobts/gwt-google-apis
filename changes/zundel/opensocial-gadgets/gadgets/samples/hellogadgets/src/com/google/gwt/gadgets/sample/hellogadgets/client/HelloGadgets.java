/*
 * Copyright 2008 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.gadgets.sample.hellogadgets.client;

import com.google.gwt.gadgets.client.DynamicHeightFeature;
import com.google.gwt.gadgets.client.Gadget;
import com.google.gwt.gadgets.client.NeedsDynamicHeight;
import com.google.gwt.gadgets.client.Gadget.ModulePrefs;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * HelloWorld Gadget.
 */
// Added comments at the end of each line to break up Eclipse's auto formatting.
@ModulePrefs(//
title = "Hello GWT for gadgets!", //
directory_title = "HelloGadgets - Google APIs for GWT", //
author = "Eric Ayers", //
author_email = "zundel@google.com", //
thumbnail = "gwt-hello-gadgets-igoogle-thumb.png", //
screenshot = "gwt-hello-gadgets-igoogle.png")
public class HelloGadgets extends Gadget<HelloPreferences> implements
    NeedsDynamicHeight {
  VerticalPanel vPanel = new VerticalPanel();
  DynamicHeightFeature dynamicHeight;
  
  protected void init(final HelloPreferences prefs) {
    Image img = new Image("http://code.google.com/webtoolkit/logo-185x175.png");
    Button button = new Button("Click me");

    vPanel.setWidth("100%");
    vPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
    vPanel.add(img);
    vPanel.add(button);
    // This panel will be added to the gadget when the DynamicHeight feature initializes.
    
    // Create the dialog box
    final DialogBox dialogBox = new DialogBox();

    // The content of the dialog comes from a User specified Preference
    dialogBox.setText(prefs.promptSomethingElse().getValue());
    dialogBox.setAnimationEnabled(true);
    Button closeButton = new Button("Close");
    VerticalPanel dialogVPanel = new VerticalPanel();
    dialogVPanel.setWidth("100%");
    dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
    dialogVPanel.add(closeButton);

    closeButton.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        dialogBox.hide();
      }
    });

    // Set the contents of the Widget
    dialogBox.setWidget(dialogVPanel);

    button.addClickListener(new ClickListener() {
      public void onClick(Widget sender) {
        dialogBox.center();
        dialogBox.show();
      }
    });
  }

  public void initializeFeature(DynamicHeightFeature feature) {
    dynamicHeight = feature;
    dynamicHeight.getContentDiv().add(vPanel);
    dynamicHeight.adjustHeight(210);
  }
}