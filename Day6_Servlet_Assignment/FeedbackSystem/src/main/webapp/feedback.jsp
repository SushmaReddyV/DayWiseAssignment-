<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Feedback Form</title>
</head>
<body>
 <h2>Student Feedback Form</h2>
    <form method="post" action="submitFeedback">
        Name: <input type="text" name="studentName" required><br><br>
        Email: <input type="email" name="email" required><br><br>
        Course Attended:
        <select name="course">
            <option value="Java">Java</option>
            <option value="Python">Python</option>
            <option value="Data Science">Data Science</option>
        </select><br><br>
        Feedback:<br>
        <textarea name="feedback" rows="5" cols="30" required></textarea><br><br>
        <input type="submit" value="Submit Feedback">
    </form>
</body>
</html>