# LAB3 – Navigation & Formulaire

An Android app built as part of a mobile development lab. The user fills in a contact form (name, email, phone, address, city) and navigates to a second screen displaying a full summary of the entered data.

---

## Demo


https://github.com/user-attachments/assets/028cbda3-4ab8-4d22-a850-ccb25de6b43a


## Screenshots

| Form Screen | Summary Screen |
|---|---|
| ![Form](https://github.com/user-attachments/assets/a8fad4fd-6b97-48f7-aa68-72fba2ed8dcc) | ![Summary](https://github.com/user-attachments/assets/12157ed5-a872-4c55-9f59-919934b566dd) |

## Features

- Contact form with 5 input fields
- Email format validation using `Patterns.EMAIL_ADDRESS`
- Required field validation (name + email)
- Navigates to a summary screen using an explicit Intent
- Data passed between screens using `putExtra` / `getStringExtra`
- Form resets automatically when returning from the summary screen
- Share button to send the summary via any app (Gmail, WhatsApp, SMS...)
- Go Back button using `finish()`

---

## App Flow

```
MainActivity (Form)
      │
      │  startActivity(Intent)
      │  putExtra(name, email, phone, address, city)
      ▼
Screen2Activity (Summary)
      │
      │  getIntent().getStringExtra(...)
      │  displays recap
      │
      │  finish() on Back button
      ▼
MainActivity (Form resets via onResume)
```

---

## Key Concepts Used

| Concept | Description |
|---|---|
| `ScrollView` | Allows the form to scroll on small screens |
| `EditText` + `inputType` | Input fields with appropriate keyboards |
| `Patterns.EMAIL_ADDRESS` | Built-in Android email format validator |
| `Intent` (explicit) | Navigate from MainActivity to Screen2Activity |
| `putExtra / getStringExtra` | Pass data between Activities |
| `getIntent()` | Retrieve the Intent that launched Screen2 |
| `onResume()` | Reset form fields when returning to MainActivity |
| `finish()` | Destroy Screen2 and return to MainActivity |
| `Intent.ACTION_SEND` | Share recap via implicit Intent |
| `safe()` | Helper method handling null and empty values |
| `AndroidManifest.xml` | Required registration of both Activities |

---

## Project Structure

```
LAB3-Navigation/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/example/lab3/
│           │   ├── MainActivity.java
│           │   └── Screen2Activity.java
│           ├── res/
│           │   └── layout/
│           │       ├── activity_main.xml
│           │       └── activity_screen2.xml
│           └── AndroidManifest.xml
└── README.md
```

---

## Tech Stack

- **Language:** Java
- **Platform:** Android
- **Min SDK:** API 24 (Android 7.0)
- **IDE:** Android Studio

---

## How to Run

1. Clone this repository
```bash
git clone https://github.com/Laila071/LAB3.git
```
2. Open the project in **Android Studio**
3. Run it on an emulator or a physical device using the **Run** button

---

## Author

- **Name:** Laila ELAMIRI
- **Course:** Mobile Development
- **Year:** 2026
