/*
 * Copyright 2015 Tinbytes Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tinbytes.simplebroadcastreceiverapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SimpleBroadcastReceiverActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_simple_broadcast_receiver);
    findViewById(R.id.bSendBroadcast).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        sendBroadcast();
      }
    });
    findViewById(R.id.bSendStickyBroadcast).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        sendStickyBroadcast();
      }
    });
    findViewById(R.id.bSendOrderedBroadcast).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        sendOrderedBroadcast();
      }
    });
  }

  private void sendBroadcast() {
    Intent intent = new Intent(SimpleBroadcastReceiver.ACTION);
    intent.putExtra("message", "This is a simple broadcast action");
    sendBroadcast(intent);
  }

  private void sendStickyBroadcast() {
    Intent intent = new Intent(StickyBroadcastReceiver.ACTION);
    intent.putExtra("message", "This is a sticky broadcast action");
    sendStickyBroadcast(intent);
  }

  private void sendOrderedBroadcast() {
    Intent intent = new Intent(OrderedBroadcastReceiver.ACTION);
    intent.putExtra("message", "This is an ordered broadcast action");
    sendOrderedBroadcast(intent, null);
  }
}
