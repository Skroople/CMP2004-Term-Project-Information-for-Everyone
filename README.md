# Information for Everyone

<img src="app/src/main/res/mipmap-xxxhdpi/ic_launcher.webp" align="right" width="120">

**Information for Everyone** is an Android mobile application designed specifically to assist disadvantaged individuals by providing highly accessible, free, and easy-to-understand information regarding health, legal rights, and social support services.

This project was developed as the Term Project for the **CMP2004 Advanced Programming** course (Spring 2025–2026).

**Developers:** Mehmet Eren Ekşi (2364932) & Yiğit Erel (2483739)

---

## 🌟 Features

- **Accessible Interface:** Developed with Material Design 3 principles. Features large, readable text, high-contrast colors (Indigo/Soft Blue theme), and elevated CardViews for easy navigation.
- **Categorized Information:** Curated advice split into three main areas:
  - 🏥 **Health:** Tips, medication safety, and mental health support.
  - ⚖️ **Legal:** Understanding rights and finding legal aid.
  - 🤝 **Social Support:** Housing, food assistance, and community help.
- **Real-Time Daily Tips:** Integrates with the [Advice Slip API](https://api.adviceslip.com/) via asynchronous background tasks to display a real-time, dynamic "Tip of the Day" directly on the category screens.
- **Daily Notifications:** Employs an Android `Service` and `BroadcastReceiver` (boot listener) to push automated daily tip notifications to the user (with full Android 13+ runtime permissions support).
- **Emergency Tools:** One-tap emergency calling functionality via explicit Intents (Dial 112).
- **Feedback System:** Built-in email intent system allowing users to easily send feedback directly to the developers.

## 🛠️ Technical Structure

- **Language:** Java
- **Target SDK:** API 36 (Android 15+)
- **Minimum SDK:** API 24 (Android 7.0)
- **Architecture:** Standard Android MVC Architecture
  - Singletons for data repository (`InfoRepository`)
  - Background `AsyncTask`/`HttpURLConnection` logic for network calls (`HttpRequestTask`)
  - Custom `RecyclerView` Adapters with click listener interfaces
- **UI & Animations:** Fully custom XML layouts, `<style>` and `<theme>` implementations, combined with custom XML micro-animations (e.g., slide-ins, fade-ups).

## 🚀 How to Run

1. Clone this repository to your local machine:
   ```bash
   git clone https://github.com/Skroople/CMP2004-Term-Project-Information-for-Everyone.git
   ```
2. Open the project in **Android Studio**.
3. Allow Gradle to sync and download all necessary dependencies.
4. Click the **Run** ▶️ button to build the app on an Android Emulator or a physical device connected via USB/Wi-Fi debugging.
5. *Note: Upon first launch, the app will request Notification permissions (for devices running Android 13 or newer). Tap "Allow" to enable the Tip of the Day notifications.*

## 📄 License & Integrity

This project was built from scratch and adheres strictly to the academic integrity policies set forth for the CMP2004 Advanced Programming course. 
