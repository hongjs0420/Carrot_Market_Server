# CarrotMarket_test_Server_Skrr_Hoy
<<<<<<< HEAD
=======

10/30 개발 일지

오늘 오전 10시에 진행된 라이징 테스트 OT를 통해 팀 배정이 되었고 구현해야 할 주제가 정해졌다. 우리팀은 당근 마켓을 구현하게 되었다.
생소한 앱을 구현해야하면 분석에 많은 시간이 들 것 같아 걱정이었는데 생각보다는 익숙한 앱을 하게되어 좋았다.
OT 이후 바로 기획서 작성을 해야해서 프론트 분들과 첫 릴레이 회의를 하게 되었는데, 처음으로 하는 협업이라 두 분 께서 친절하게 해주셨는데도 불구하고 의견을 나누는데 시간이 걸렸다.
각자의 의견을 보충해가며 기획서를 작성하였고 시간안에 잘 제출할 수 있었다. 후에 개발 트레이너 분들의 피드백을 받아 수정했다.

파일 : [-.pdf](https://github.com/mock-rc2/CarrotMarket_test_Server_Skrr_Hoy/files/7446724/-.pdf)

이후 Server는 두 명이서 한 서버를 구축하기 때문에 바로 이어서 스컬님과 ERD 짜기에 돌입했다.

같이 큰 틀을 짰는데, Location을 어떤식으로 처리할 지에 대해 많은 의견이 주고받아졌고 구현 방향이 정해졌다.
우리가 시도하는 방식은 town에 서울의 모든 행정동과 행정동의 위경도를 저장하고(약 400개), 홈 화면 등에서 위치에 따른 물품 조회를 하면 조회하려는 지역의 위경도에서 반경 N km 주변의 좌표르 구해 그 좌표 내에 중심 좌표가 있는 행정동에서 올라온 물품을 나타내는 식으로 구현할 예정이다.
나는 유저와 로케이션, 채팅 쪽 ERD를 위주로 구성하였다.

ERD 링크 : https://app.quickdatabasediagrams.com/#/d/JD5GzH

내일은 API 명세서와 서버 구축을 할 예정이다.


10/31 개발 일지

오늘 오후 2시부터 11시까지 약 9시간 동안 스컬님과 회의를 하였다.

오늘은 어제 진행했던 ERD의 일부 컬럼을 수정하고 보완하는 작업을 한 뒤, 위경도를 받아 주소로 변환해 주는 작업을 프론트 단에서 진행할지 백엔드 단에서 진행할지에 대한 회의를 한 후 API 명세서를 작업하였다.

반경 안에 행정동을 검색하는 것이 큰 문제인데, 이 부분에서 API가 없어서 수학적인 계산을 통해서 구현하려한다고 말씀드리니 프론트 팀에서 그 작업이 부담이 될 것 같다고 위경도 받아 주소로 변환하는 부분을 맡아주시겠다고 해서 많이 감사했다.

화면을 보면서 기능을 일일히 분석해 약 33개의 API 리스트를 작성하였는데, 스컬님은 화면 중심의 API와 도메인을 구성해보신 것 같았고 난 기능 중심의 API와 도메인을 생각하다보니 약간 서로 설득하는? 시간이 필요했다. 그러나 스컬님과 나 모두 좋은 기분으로 서로의 생각을 잘 전달할 수 있었기에 큰 문제 없이 수월하게 리스트를 작성했다.

API를 작성할 때 프론트를 담당하시는 록키님 한테도 어떤식으로 줘야할지, 어떤식으로 쓸 수 있으신지를 계속 여쭤봤고 나름 원활하게 커뮤니케이션을 하였다.

API 명세서 : [API 명세서 Templete_초고.xlsx](https://github.com/mock-rc2/CarrotMarket_test_Server_Skrr_Hoy/files/7449017/API.Templete_.xlsx)


둘 다 9시간동안 계속하여 구글 meet으로 API 리스트 작업을 진행하다보니 많은 피로감이 느껴져서 디테일하게 API를 볼 수 없느 상태가 되어서 오늘은 API 명세서 작업까지만 하고 내일 오늘 한 명세서의 보완 작업과 서버 구축 후 API를 만들어 보기로 했다.



11/1 개발일지

오늘은 스컬님과 어제 작성한 API 명세서를 다듬어서 어제 잘못 기입한 부분들을 수정하고, 서버를 구축한 뒤 ERD를 DB에 넣는 작업을 우선적으로 진행하였다.

API 명세서의 경우에는 여러 API를 빠른 시간 내에 짜다보니 method 부분이나 URL 부분에 문제가 있는 경우가 있어서 좀더 간략화하고 기능적으로 바꾸려고 노력했다.


API 명세서 수정본 :[API 명세서 Templete_중반.xlsx](https://github.com/mock-rc2/CarrotMarket_test_Server_Skrr_Hoy/files/7454040/API.Templete_.xlsx)

ERD를 막상 DB에 넣기 위해 SQL 문으로 뽑으니 오탈자가 많이 있어 수정하는 시간이 필요했다. 자동으로 인덱스가 증가하는 부분도 넣지 않은 걸 깨달아서 여러번 수정하였다.

SQL에 삽입할 ERD 최종 : [QuickDBD-Carrot.txt](https://github.com/mock-rc2/CarrotMarket_test_Server_Skrr_Hoy/files/7454064/QuickDBD-Carrot.txt)


서버 구축을 마친 뒤, DB를 추가한 다음 큰 과제가 남았었는데, 바로 서울의 모든 행정동을 테이블에 담는 내용이었다. 전 날, 내가 구글링을 통해 mysql에서 위경도가 있을 경우 반경 n km 안에 있는 좌표를 찾는 쿼리문을 찾아와 스컬님과 상의를 하였는데 이걸 구현하기 위해서는 테이블에 모든 행정동의 대표 위경도가 필요했기 때문이다. 다행이도 구글링 결과 누군가가 엑셀 파일로 정리해 놓은 행정동 모음이 있었고, 엑셀의 중복 데이터 제거 기능을 이용해 중복된 행정동을 제거한 후 데이터를 datagrip으로 삽입이 가능하게 csv파일로 만들어서 Town 테이블에 넣을 수 있었고, 쿼리문 테스트 결과 실행이 잘 되는것을 확인할 수 있었다.

행정동 정리 엑셀, csv :[서울시_행정동_좌표2.csv](https://github.com/mock-rc2/CarrotMarket_test_Server_Skrr_Hoy/files/7454051/_._.2.csv)
[서울시_행정동_좌표.xlsx](https://github.com/mock-rc2/CarrotMarket_test_Server_Skrr_Hoy/files/7454053/_._.xlsx)


이후, user의 회원가입 기능과 logIn 기능을 담당하는 api를 제작하였다. 나는 logIn 기능을 맡았으며 스컬님이 회원가입 기능을 구현하셨다.

내일은 api 명세서를 기능을 고려해 분담하는 과정을 거친 후 본격적으로 api를 제작할 예정이다.

11/2 개발일지

오늘은 제작한 api에 대해 프론트 분들과 얘기해서 수정하는 시간을 갖은 후, 피드백을 받기 위해 영상을 제작해 피드백을 받았다.

안정적으로 생각보다 잘만들었다고 생각했는데 엘레나의 조언을 듣고 보니 굉장히 많은 부분에서 실수를 했다는 걸 알 수 있었고, 짠 구조에서도 여러 문제가 있어서 스컬님과 얘기해보라고 해주셨다.

또한 현재 서울로만 지역을 한정했었는데 당근마켓은 전국적으로 제공하는 서비스이니 주소 체계가 다른부분을 검토해서 전국 서비스로 구현해보라는 피드백을 받았다.

API명세서 역시 문제가 많았는데, 한번 검토를 한 후에 스컬님과 공유를 하고 있었으나 스프레드 시트로 공유해야 한다는 사실을 잊고 있어서 부랴부랴 추가했으며, 검토 후에도 틀린 부분이 많았고, 스네이크 케이스로 쓰지 않고 카멜 케이스로 쓴다거나 url에 필요없는 쿼리스트링이 존재한다거나 공백이 존재한다거나 하는 문제들이 많았으며, 협업을 같이 하는 것으로 오해하고 여러 부분들을 같이 설계하다보니 역할 분담이 제대로 되지않았던 문제가 있었다.

또한 서버를 항상 켜놓으라고 말씀해주셨다.

피드백 이후에 우리는 DB에서 피드백받았던 수정사항을 바꾼 후, 전국적으로 동작할 수 있게 디비를 일부 수정하고 데이터를 넣었다.

개발일지를 쓴 이후에는 명세서 수정을 진행할 것이다.

수정한 ERD 최종 : https://app.quickdatabasediagrams.com/#/d/JD5GzH

API 명세서 : https://docs.google.com/spreadsheets/d/1wmm6zQDVHvNAgIDc217vzNfrzQnAEfTgeliGeBPBEvk/edit#gid=1340372136

전국 행정동(리 제외) 엑셀 시트, csv :[행정_법정동 중심좌표.csv](https://github.com/mock-rc2/CarrotMarket_test_Server_Skrr_Hoy/files/7461695/_.csv)
[행정_법정동 중심좌표.xlsx](https://github.com/mock-rc2/CarrotMarket_test_Server_Skrr_Hoy/files/7461696/_.xlsx)


전국 리,기타주소 엑셀시트, csv :[행정_법정동 중심좌표_리.csv](https://github.com/mock-rc2/CarrotMarket_test_Server_Skrr_Hoy/files/7461679/_._.csv)
[행정_법정동 중심좌표_리.xlsx](https://github.com/mock-rc2/CarrotMarket_test_Server_Skrr_Hoy/files/7461686/_._.xlsx)

11/3 개발 일지

오늘은 서버를 구축해 가동하고, 본격적으로 api를 만드는 작업을 하였다.

본격적으로 만들기 전, 프론트 분들과 회의를 진행 하였는데 인증번호를 비밀번호 처럼 저장하여 인증번호를 받아 입력하는 것 처럼 구현하는 방법에 대해 의견을 구했고, 프론트 분들도 그게 최선일 듯 하다고 동의해주셔서 그렇게 진행하기로 했다.

또한 역할을 나눴는데 나는 post 관련한 api와 즐겨찾는 상품에 관련한 api를 담당했고, 스컬은 주소에 관련한 api와 카테고리에 관련한 api를 맡았다.

git사용법에 익숙치 못해 프로젝트가 깨져서 폴더가 표시가 안되는 일이 있었는데, 이리저리 시간을 넣어서 해결했고 서버도 post가 포트번호를 넣어야만 동작하는 일이 있어서 그부분 해결하는데 고생했다.

내일은 스컬님이 주소 받는 api를 완성해주시면 그걸 기반으로 게시글 검색을 해보려 한다.

>>>>>>> hoy_branch
