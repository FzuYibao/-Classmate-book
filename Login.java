<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    >

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@+id/passwordLayout_login"
        android:id="@+id/login"
        android:text="��          ¼"
        android:textSize="20sp"
        android:background="@color/colorPrimaryDark"
        />


    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/login"
        android:layout_marginTop="10dp"
        android:layout_marginLeft="5dp"
        android:id="@+id/register"
        android:text="�� �� �� ע ��"
        android:textColor="@color/colorAccent"
        />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/login"
        android:layout_alignRight="@+id/login"
        android:layout_marginTop="10dp"
        android:layout_marginRight="5dp"
        android:text="�� �� �� ��?"
        android:textColor="@color/colorAccent"

        />

    <android.support.design.widget.TextInputLayout
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:id="@+id/userLayout_login"
        android:textColorHint="@color/colorBlack"
        android:layout_below="@+id/logo_login"
        android:layout_marginTop="30dp"
        >

        <EditText
            android:id="@+id/userName_login"
            android:layout_marginLeft="10dp"
            android:layout_marginRight="10dp"
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:textSize="25sp"
            android:hint="�û���"
            />
    </android.support.design.widget.TextInputLayout>

    <android.support.design.widget.TextInputLayout
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:id="@+id/passwordLayout_login"
        android:textColorHint="@color/colorBlack"
        android:layout_below="@+id/userLayout_login"
        >

        <EditText
            android:id="@+id/password_login"
            android:layout_marginLeft="10dp"
            android:layout_marginRight="10dp"
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:textSize="25sp"
            android:inputType="textPassword"
            android:hint="����"
            />
    </android.support.design.widget.TextInputLayout>

    <ImageView
        android:layout_width="150dp"
        android:layout_height="150dp"
        android:id="@+id/logo_login"
        android:layout_marginTop="43dp"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true" />


</RelativeLayout>