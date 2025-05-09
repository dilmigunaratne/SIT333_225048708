<!DOCTYPE html>
<html>
<head>
    <title>Math Question 3</title>
</head>
<body>
    <h2>Math Question 3: Multiplication</h2>
    <form method="post" action="/q3">
        <label>Number 1:</label>
        <input type="text" name="number1" required>
        <br>
        <label>Number 2:</label>
        <input type="text" name="number2" required>
        <br>
        <label>Your Answer:</label>
        <input type="text" name="result" required>
        <br>
        <button type="submit">Submit</button>
    </form>
    
    <div style="color:red;">
        ${message}
    </div>
</body>
</html>
