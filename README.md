FINAL PROJECT
===============================

## SCSA 2조 E1M4팀 파이널 프로젝트 보관함

* * *

## 1. 구현 기능
```
1.탄소 배출 저감과 관련한 개인의 실천 유도 방안
  -차량 2부제에 해당되는 차량 소유자가 대중교통 이용 시 그린 포인트 제공
  -하루 일정 거리 이상 걸었을 경우 그린 포인트 제공
  -전월 대비 가정 내 에너지 사용량 감축 시 그린 포인트 제공
  -대중교통 이용 시 그린 포인트 제공

2.생활 쓰레기 감축과 관련한 개인의 실천 유도 방안
  - 제휴 매장 일회용 컵 전용 분리 수거함에 회수 했을 경우 해당 카페 포인트 또는 그린 포인트 제공(사용자 선택)

3.환경 관련 개인의 인식 제고를 위한 방안
  -공원, 공공기관 등 비콘을 활용하여 환경 관련 정보를 담은 영상 시청 시 그린 포인트 제공
  -앱 내 환경 관련 정보 제공 

4.그린 마켓
  -다양한 업 사이클링 제품으로 구성된 그린 마켓에서 획득한 그린 포인트를 사용하여 구매가 가능
  -환경을 지키면서 얻은 보상이 재활용 제품의 구매로 이어지는 선순환 구조의 구매 사이클을 유도
```

## 2. 구현 완료 기능 
### 2.1 BackEnd
  - 서버 및 데이터베이스 기초 구축
  - 서버 측 Model, Controller 기본 구현
  - 로그인, 회원가입 등 회원 관리 관련 기능 구현
### 2.2 FrontEnd
  - 인트로 뷰 구현
  - 메인 화면 뷰 기본 구현
  - BottomNavigation 구현 
### 2.3 Hardware
  - 스텝모터 제어 
  - SimpleCV를 이용한 카메라 QR코드 인식

## 3. 현시점 구현 예정 기능
### 3.1 BackEnd
  - 구글 맵 API 관련 기능 구현
  - 포인트 적립/사용 (DAO) 구현
  - 바코드 관련 데이터 설계
### 3.2 FrontEnd
  - 로그인/회원가입 페이지 구현
  - 탄소 저감 관련 기능 페이지 구현
  - 메인 화면 뷰 강화
### 3.3 HardWare
  - OpenCV 구축 및 바코드 인식 강화
  - 카메라와 스텝모터 연동
  - 라즈베리파이 DB 접근 (python)
  
## 4. 그후 프로젝트 예정
#### 2주차 (6.4 ~ 6.8)
  - Estimote (Beacon) 관련 기능 구현
  - 맵 화면 뷰 구현
  - 탄소 저감 관련 기능 페이지 강화 (걷기 등)
  - DB를 통해 바코드 유효성 체크 기능 구현
  - 종이컵 수거 완료시 포인트 추가 기능 구현
#### 3주차 (6.11 ~ 6.15)
  - 그린마켓 기능 구현
  - 그린마켓 뷰 구현
  - 개인설정페이지 구현 
  - 수거함 프로토타입 제작
### 4주차 (6.18 ~ 최종발표일)
  - 마무리 및 Develop
  
