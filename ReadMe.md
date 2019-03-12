<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
 "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd"> 

<html xmlns="http://www.w3.org/1999/xhtml">
	
<head>
	<title>	</title>
<meta charset= "utf-8" />
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" /> 
  <style>
	@charset "utf-8";
    body{
      background-color: #FFFFFF;
      font-family: 'Roboto', sans-serif;
    }
    
    .Header{
      font-size: 23pt;
      color: #000000;
	  position: absolute;
	  left: 0;
	  top: 0;
	  width: 1360px;
	  height: 220px;
	  border: 2px solid #000000;
	  z-index = 1000;
    }
	
	.Header h1{
		position: absolute;
		left: 40%;
		top: 15%;
	}
	
	#Logo{
		height: 200px;
		width: 200px;
		position: absolute;
		left: 5%;
		top: 5%;
	}
	
	.content{
		width: 1360px;
		position: absolute;
		top: 220px;
		left: 15px;
		font-size: 17pt;
	}
  </style>
</head>
<body>
	<div class="Header">
		<img id="Logo" src="https://cdn4.iconfinder.com/data/icons/iconsimple-logotypes/512/github-512.png"  />
		<h1>ReadMe.md</h1>
	</div>
	<div class="content">
		<p>
			This project created for Educational Purpose only.<br />
			Created by CuaMcCarsaree754. Submitted at 5:06 PM 03/12/2019 UTC+8<br />
			Please mind to read my Notes.txt thank you<br />
		</p>
		Check out this <a onclick='trigger()' href="https://www.facebook.com/yosua.kristianto.5">link</a> for more information
	</div>
  
  <script type="text/javascript">
	function trigger() { alert("You've been trapped"); }
  </script>
</body>
</html>
