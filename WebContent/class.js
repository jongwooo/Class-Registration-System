function campusChange() {
  var yongin = ["분류 선택", "교양", "공과대학", "자연과학대학", "예술체육대학", "건축대학"];
  var seoul = ["분류 선택", "교양", "ICT융합대학", "경영대학", "사회과학대학", "인문대학", "법학대학"];
  var select = ["분류 선택"];

  var selectCampus = $("#campus").val();
  var changeCampus;

  if (selectCampus == "용인캠퍼스") {
    changeCampus = yongin;
    $('#college').attr('onchange', 'yonginChange()');
  } else if (selectCampus == "서울캠퍼스") {
    changeCampus = seoul;
    $('#college').attr('onchange', 'seoulChange()');
  } else {
    changeCampus = select;
  }

  $('#college').empty();

  for (var count = 0; count < changeCampus.length; count++) {
    var option = $("<option value='" + changeCampus[count] + "'>" + changeCampus[count] + "</option>");
    $('#college').append(option);
  }
}

function yonginChange() {
  var generalY = ["영어교양", "기초교양", "선택교양"];
  var engineering = ["전기공학과", "컴퓨터공학과"];
  var science = ["수학과", "물리학과", "화학과", "식품영양학과", "생명과학정보학과"];
  var art = ["디자인학부", "체육학부", "음악학부", "바둑학과", "영화뮤지컬학부"];
  var architecture = ["건축학부", "공간디자인전공"];
  var select = ["분류 선택"];

  var selectCollegeY = $("#college").val();
  var changeCollegeY;

  if (selectCollegeY == "교양") {
    changeCollegeY = generalY;
  } else if (selectCollegeY == "공과대학") {
    changeCollegeY = engineering;
  } else if (selectCollegeY == "자연과학대학") {
    changeCollegeY = science;
  } else if (selectCollegeY == "예술체육대학") {
    changeCollegeY = art;
  } else if (selectCollegeY == "건축대학") {
    changeCollegeY = architecture;
  } else {
    changeCollegeY = select;
  }

  $('#department').empty();

  for (var count = 0; count < changeCollegeY.length; count++) {
    var option = $("<option value='" + changeCollegeY[count] + "'>" + changeCollegeY[count] + "</option>");
    $('#department').append(option);
  }
}

function seoulChange() {
  var generalS = ["영어교양", "기초교양", "선택교양"];
  var ict = ["디지털콘텐츠", "융합소프트웨어"];
  var business = ["경영학과", "국제통상학과", "경영정보학과", "부동산학과", "경영교육혁신센터"];
  var social = ["행정학과", "경제학과", "정치외교학과", "디지털미디어학과", "아동학과", "청소년지도학과", "사회복지학과"];
  var human = ["국어국문학과", "중어중문학과", "일어일문학과", "영어영문학과", "사학과", "문헌정보학과", "미술사학과", "철학과", "아랍지역학과", "문예창작과"];
  var law = ["법학과", "법무정책학과"];
  var select = ["분류 선택"];

  var selectCollegeS = $("#college").val();
  var changeCollegeS;

  if (selectCollegeS == "교양") {
    changeCollegeS = generalS;
  } else if (selectCollegeS == "ICT융합대학") {
    changeCollegeS = ict;
  } else if (selectCollegeS == "경영대학") {
    changeCollegeS = business;
  } else if (selectCollegeS == "사회과학대학") {
    changeCollegeS = social;
  } else if (selectCollegeS == "인문대학") {
    changeCollegeS = human;
  } else if (selectCollegeS == "법학대학") {
    changeCollegeS = law;
  } else {
    changeCollegeS = select;
  }

  $('#department').empty();

  for (var count = 0; count < changeCollegeS.length; count++) {
    var option = $("<option value='" + changeCollegeS[count] + "'>" + changeCollegeS[count] + "</option>");
    $('#department').append(option);
  }
}
