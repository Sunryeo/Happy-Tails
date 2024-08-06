import {URL} from "./constant.js";

document.addEventListener('DOMContentLoaded', fetchUserInfo);
document.addEventListener('DOMContentLoaded', fetchUserPosts);

// 사용자 정보 가져오기
function fetchUserInfo() {
    fetch(URL + '/this/info', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response =>
            response.json()
        )
        .then(data => {
            // 사용자 정보를 화면에 표시
            document.getElementById('board-username').textContent = data.userName;
            document.getElementById('board-user-createdAt').textContent = data.createdAt;
            document.getElementById('board-user-phone').textContent = data.phone;
            document.getElementById('board-user-email').textContent = data.email;
            document.getElementById('user-posting-count').textContent = data.postCount;

            // 글 목록 가져오기
            fetchUserPosts();
        })
        .catch(error => {
            console.error('Error fetching user info:', error);
        });
}

// 사용자가 작성한 글 목록 가져오기
function fetchUserPosts() {
    fetch(URL +'/this/post', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(posts => {
            // console.log("posts: ", posts)

            const postListBody = document.getElementById('post-list-body');
            posts.forEach(post => {
                let approveStatus;
                if(post.approveStatus === "APPROVED") {
                    approveStatus = '진행중인 공고'
                } else {
                    approveStatus = '승인 대기중인 공고'
                }
                const row = document.createElement('tr');
                row.classList.add('height-35', 'my-page-table-line-bottom');
                row.innerHTML = `
                        <td><input type="checkbox" class="checkbox-all"></td>
                        <td class="post-posting">${approveStatus}</td>
                        <td>${post.title}</td>
                        <td class="post-created">${post.createdAt}</td>
                    `;
                postListBody.appendChild(row);
            });
        })
        .catch(error => {
            console.error('Error fetching user posts:', error);
        });
}

document.addEventListener('DOMContentLoaded', function () {
    // 글쓰기 버튼 클릭
    const writeButton = document.getElementById('write-button');
    writeButton.addEventListener('click', function () {
        console.log('글쓰기 버튼 클릭됨');
        // 글쓰기 페이지로 이동
        window.location.href = '/write';
    });

    // 삭제 버튼 클릭
    const deleteButton = document.getElementById('delete-button');
    deleteButton.addEventListener('click', function () {
        console.log('삭제 버튼 클릭됨');
        // 선택된 항목 삭제
        const checkboxes = document.querySelectorAll('.checkbox-all');
        checkboxes.forEach(checkbox => {
            if (checkbox.checked) {
                checkbox.closest('tr').remove();
            }
        });
    });
});