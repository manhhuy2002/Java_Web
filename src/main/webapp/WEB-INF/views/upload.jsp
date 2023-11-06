<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>File Upload</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <h1 class="mt-5">File Upload</h1>
  <form class="mt-5" action="/upload" method="post" enctype="multipart/form-data">
    <div class="mb-3">
      <label for="fileInput" class="form-label">Select File</label>
      <input class="form-control" type="file" id="fileInput" name="file">
    </div>
    <button class="btn btn-primary" type="submit">Upload</button>
  </form>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>