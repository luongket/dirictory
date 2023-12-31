package database;


import com.sun.speech.freetts.Voice;
import Base.App.Word;
import com.sun.speech.freetts.VoiceManager;

import java.sql.*;
import java.util.ArrayList;

public class DictionaryManagement {
    // Kết nối đến cơ sở dữ liệu
    private static Connection connection;

    public DictionaryManagement() {
        connection = DBConnection.getConnection();
    }

    public static DictionaryManagement getInstance() {
        return new DictionaryManagement();
    }

    public static void insert(String tableName, Word word) {
        try {
            String query = "INSERT INTO " + tableName + " (word, html) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, word.getWord());
            preparedStatement.setString(2, word.getDefinition());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Word word) {
        try {
            String query = "UPDATE dictionary SET html = ? WHERE word = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, word.getDefinition());
            preparedStatement.setString(2, word.getWord());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(String tableName, String word) {
        try {
            String query = "DELETE FROM " + tableName + " WHERE word = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, word);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Word> selectAll(String tabaleName) {
        ArrayList<Word> wordList = new ArrayList<>();
        try {
            String query = "SELECT * FROM " + tabaleName + " ORDER BY word";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String wordText = resultSet.getString("word");
                String definition = resultSet.getString("html");
                Word word = new Word(wordText, definition);
                wordList.add(word);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return wordList;
    }
    public static void textToSpeech(String text) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice voice = VoiceManager.getInstance().getVoice("kevin16");
        if (voice != null) {
            voice.allocate();
            voice.speak(text);
        } else {
            throw new IllegalStateException("Cannot find voice: kevin16");
        }
    }
}
