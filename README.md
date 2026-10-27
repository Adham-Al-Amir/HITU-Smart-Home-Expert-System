<div align="center">

# 🏠 HITU Smart Home Expert System

### 🔐 Secure & Smart Living Spaces

![Java](https://img.shields.io/badge/Java-Swing-orange?logo=openjdk&logoColor=white)
![Oracle](https://img.shields.io/badge/Database-Oracle-red?logo=oracle&logoColor=white)
![NetBeans](https://img.shields.io/badge/IDE-NetBeans-1B6AC6?logo=apachenetbeanside&logoColor=white)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)

</div>

---

A rule-based **expert system** for smart home automation, built with **Java Swing** and **Oracle Database**. The system takes sensor/state inputs from the user, applies a set of rules, and returns a recommended **action** together with an **explanation** of why that action was chosen. Every decision is saved to a per-user history.

## ✨ Features

- 👤 User registration and login
- 🧠 Four expert-system modules, each with its own rule base:
  - 🌡️ **Climate Control**: AC, heater, fan, windows, and curtains based on temperature, occupancy, and window status
  - 💡 **Lighting**: automatic lights based on motion, time of day, and no-motion duration
  - 🛡️ **Security**: alarm decisions based on house mode (Home / Sleep / Away) and motion
  - 🔥 **Fire Alarm**: emergency response based on smoke sensor status and duration
- 📝 Explanation for every decision (why the action was taken)
- 📜 History page showing all previous decisions per user
- 🎨 Splash screen and a clean Swing GUI

## 📋 Rules Summary

| System | Inputs | Example Rule |
|---|---|---|
| 🌡️ Climate | Temperature, user present, window status | Temp > 30°C + user present + window open → close window, turn on AC (22°C), close curtains |
| 💡 Lighting | Motion, light status, time of day, no-motion duration | No motion for ≥ 15 min while lights are on → turn lights off |
| 🛡️ Security | House mode, motion | Motion in *Sleep* or *Away* mode → trigger alarm and notify phone |
| 🔥 Fire | Smoke sensor, smoke duration (seconds) | Smoke detected for ≥ 5 seconds → alarm, notify authorities, smoke extraction |

## 📁 Project Structure

```
src/
├── climate/                 # Climate rule base
├── common/                  # SmartSystemModule (abstract base) + DBConnection
├── fire/                    # Fire rule base
├── lighting/                # Lighting rule base
├── security/                # Security rule base
├── smarthomeexpertsystem/   # Main class (entry point)
├── uisytem/                 # All Swing GUI screens
└── icones/                  # Images / icons
database/
└── schema.sql               # Database tables script
```

Each system extends the abstract class `SmartSystemModule` and implements `evaluate()`, which sets the action (`act`) and the explanation (`exp`).

## 🧰 Requirements

- ☕ JDK 8 or later
- 🗄️ Oracle Database (XE) running on `localhost:1521`
- 🔌 Oracle JDBC driver (`ojdbc8.jar`)
- 🧑‍💻 NetBeans IDE (recommended)

## 🗄️ Database Setup

The database tables are defined in a separate file: [`database/schema.sql`](database/schema.sql).

Run that script on your Oracle database before starting the application.

## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/Adham-Al-Amir/HITU-Smart-Home-Expert-System.git
   ```
2. Open the project in NetBeans (or any Java IDE).
3. Add `ojdbc8.jar` to the project libraries.
4. Run `database/schema.sql` on your Oracle database.
5. Edit `src/common/DBConnection.java` and set your own database URL, username, and password.
6. Run the main class: `smarthomeexpertsystem.SmartHomeExpertSystem`.

## 🕹️ Usage

1. Wait for the splash screen, then **register** a new account and **log in**.
2. Choose a system from the main menu (Climate, Light, Security, Fire).
3. Enter the inputs and press **Enter** to get the recommended action and its explanation.
4. Open **History** to review all previous decisions.

## 👨‍💻 Author

**Adham Al-Amir** 🎓 HITU

---

<div align="center">

⭐ If you like this project, give it a star!

</div>
