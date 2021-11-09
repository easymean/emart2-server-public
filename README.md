# emart2-server-public

---
## WINDOW
gradlew

## LINUX
./gradlew

## 실행
`cd emart2` </br>
`./gradlew clean build` </br>
`./gradlew :redirect-api:bootRun`

## jib 사용하기

### 로컬 데몬에 바로 빌드
`./gradlew :redirect-api:jibDockerBuild --image:${이미지 이름}`

** --info : log 

## 모듈 
| 모듈명 | 설명 |
|-------|-----|
| redirect-admin | 관리자 모듈. 컨트롤러, 필터, Request/Response 객체 등 서버 어플리케이션 작성에 필요한 클래스를 포함 |
| redirect-api | 프론트 모듈. 컨트롤러, 필터, Request/Response 객체 등 서버 어플리케이션 작성에 필요한 클래스를 포함 |
| redirect-core | 모든 모듈에서 공유할 클래스들이 위치하며 DB와의 연동을 담당한다. |

## 패키지
| 패키지명 | 설명 |
|-------|-----|
| entity | JPA Entity |
| repository | JPA Repository |
| service | 비즈니스 로직 |
| api | REST API 컨트롤러 |
| application | service의 결과를 맵퍼에 맵핑 |
| dto | dto |