<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap/bootstrap.min.css">
<script src="/resources/js/jquery/jquery-3.5.1.min.js"></script>
<script src="/resources/js/bootstrap/bootstrap.bundle.min.js"></script>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>ConnecTeam, 즐거움을 연결하라 - 관리자페이지</title>

<link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/dashboard/">
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <link href="resources/css/etc/adminDashboard.css" rel="stylesheet">
  </head>
  <body>
    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3 text-c" href="/index.do">ConnecTeam</a>
  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse" data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <input class="form-control form-control-dark w-100" type="text" placeholder="검색..." aria-label="Search">
  <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <a class="nav-link" href="/member/memberLogout.do">로그아웃</a>
    </li>
  </ul>
</nav>

<div class="container-fluid">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="sidebar-sticky pt-3">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" href="#">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-home"><path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path><polyline points="9 22 9 12 15 12 15 22"></polyline></svg>
              <span data-feather="home"></span>
               대시보드 <span class="sr-only"></span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
              <span data-feather="shopping-cart"></span>
              상품관리
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-cart"><circle cx="9" cy="21" r="1"></circle><circle cx="20" cy="21" r="1"></circle><path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path></svg>
              <span data-feather="file"></span>
             판매관리
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-users"><path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path><circle cx="9" cy="7" r="4"></circle><path d="M23 21v-2a4 4 0 0 0-3-3.87"></path><path d="M16 3.13a4 4 0 0 1 0 7.75"></path></svg>
              <span data-feather="users"></span>
              이용자관리
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-layers"><polygon points="12 2 2 7 12 12 22 7 12 2"></polygon><polyline points="2 17 12 22 22 17"></polyline><polyline points="2 12 12 17 22 12"></polyline></svg>
              <span data-feather="layers"></span>
              컨텐츠관리
            </a>
          </li>
           <li class="nav-item">
            <a class="nav-link" href="#">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-bar-chart-2"><line x1="18" y1="20" x2="18" y2="10"></line><line x1="12" y1="20" x2="12" y2="4"></line><line x1="6" y1="20" x2="6" y2="14"></line></svg>
              <span data-feather="bar-chart-2"></span>
              통계자료
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text"><path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path><polyline points="14 2 14 8 20 8"></polyline><line x1="16" y1="13" x2="8" y2="13"></line><line x1="16" y1="17" x2="8" y2="17"></line><polyline points="10 9 9 9 8 9"></polyline></svg>
              <span data-feather="file-text"></span>
              고객지원
            </a>
          </li>
        </ul>
      </div>
    </nav>

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">주간판매통계</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
          <div class="btn-group mr-2">
            <button type="button" class="btn btn-sm btn-outline-secondary">공유</button>
            <button type="button" class="btn btn-sm btn-outline-secondary">다운로드</button>
          </div>
          <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
            <span data-feather="calendar"></span>
            이번 주
          </button>
        </div>
      </div>

      <canvas class="my-4 w-100 chartjs-render-monitor" id="myChart" width="584" height="246" style="display: block; width: 584px; height: 246px;"></canvas>

      <h2>고객센터 현황</h2>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th>번호</th>
              <th>제목</th>
              <th>아이디</th>
              <th>문의내용</th>
              <th>답변</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1</td>
              <td>질문이 있습니다</td>
              <td>coderbear</td>
              <td>ConnecTeam은 어떤 사이트인가요?</td>
              <td>N</td>
            </tr>
            <tr>
              <td>2</td>
              <td>회원탈퇴 하고 싶습니다</td>
              <td>coderbear2</td>
              <td>어디에서 회원 탈퇴가 가능한가요?</td>
              <td>Y</td>
            </tr>
            <tr>
              <td>3</td>
              <td>구매한 상품내역을 삭제하고 싶습니다</td>
              <td>coderbear3</td>
              <td>11/20일에 샀던 monster hunter 내역을 삭제해주세요</td>
              <td>N</td>
            </tr>
            <tr>
              <td>4</td>
              <td>회원정보 수정하고 싶습니다</td>
              <td>eaden77</td>
              <td>회원정보에 휴대폰번호를 잘못 입력해서 수정하고 싶어요</td>
              <td>N</td>
            </tr>
            <tr>
              <td>5</td>
              <td>샀던 게임이 맘에 안들어서 환불하고 싶어요</td>
              <td>allend16</td>
              <td>너무 재미없어서 환불할래요 처리해주세요</td>
              <td>Y</td>
            </tr>
            <tr>
              <td>6</td>
              <td>게임 개발사인데 여기 유저가 이상한 리뷰를 달아서 삭제하고 싶습니다</td>
              <td>nexon</td>
              <td>저희 돈슨이라고 욕한 리뷰 좀 삭제해주세요 ㅠㅠ</td>
              <td>N</td>
            </tr>
            <tr>
              <td>7</td>
              <td>인기게임 선정 기준은 무엇인가요?</td>
              <td>bigdaditor</td>
              <td>인기게임 리스트는 어떤 기준으로 선정되는건지 궁금합니다</td>
              <td>Y</td>
            </tr>
            <tr>
              <td>8</td>
              <td>결제 취소 신청했던 건은 언제 환불되나요?</td>
              <td>librarian16</td>
              <td>결제 취소 신청했던 건의 환불 처리 기간이 궁금합니다</td>
              <td>N</td>
            </tr>
            <tr>
              <td>9</td>
              <td>connecTeam의 채용시기는 언제인가요?</td>
              <td>connecteamlover</td>
              <td>향후 채용공고 시기가 궁금합니다</td>
              <td>N</td>
            </tr>
            <tr>
              <td>10</td>
              <td>connecTeam에 저희 게임을 등록하고 싶어요</td>
              <td>dev</td>
              <td>저희가 새로 만든 게임을 등록하고 싶은데 어떤 절차를 밟으면 되나요?</td>
              <td>Y</td>
            </tr>
            <tr>
              <td>11</td>
              <td>connecTeam에 광고제의를 하고 싶습니다</td>
              <td>bruce</td>
              <td>저희 게임을 홍보하는 광고를 넣고 싶은데 어디로 연락드리면 되나요?</td>
              <td>Y</td>
            </tr>
            <tr>
              <td>12</td>
              <td>다른 유저가 악의적인 리뷰를 달았습니다</td>
              <td>hater</td>
              <td>allend17이라는 유저가 다른 사람을 공격하는 악의적인 리뷰를 달아서 삭제해주세요</td>
              <td>Y</td>
            </tr>
            <tr>
              <td>13</td>
              <td>탈퇴 후 기존 게임내역 조회가 가능한가요?</td>
              <td>sadness</td>
              <td>1년 전에 탈퇴를 했는데 급하게 게임 구매내역이 필요해서 혹시 받을 수 있을까요?</td>
              <td>N</td>
            </tr>
            <tr>
              <td>14</td>
              <td>스팀이랑 다른 이 사이트만의 차별점은 무엇인가요?</td>
              <td>steam</td>
              <td>여기 스팀이랑 비슷한거 같은데 어떤 점이 차별화되어 있는지 궁금합니다</td>
              <td>Y</td>
            </tr>
            <tr>
              <td>15</td>
              <td>탈퇴 후 동일 아이디로 재가입이 가능한가요?</td>
              <td>returnconnecteam</td>
              <td>혹시 기록을 삭제하고 싶어서 탈퇴하고 재가입하고 싶은데 동일 아이디로 재가입되나요?</td>
              <td>N</td>
            </tr>
            <tr>
              <td>16</td>
              <td>connecteam에 건의사항이 있습니다!!</td>
              <td>gamelover</td>
              <td>connecteam에서 크리스마스 할인 이벤트를 했으면 좋겠어요!</td>
              <td>N</td>
            </tr>
          </tbody>
        </table>
      </div>
    </main>
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
        <script src="dashboard.js"></script></body>
</html>
