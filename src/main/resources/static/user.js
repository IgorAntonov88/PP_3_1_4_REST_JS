const url_user = "http://localhost:8080/api/user"
const tableUser = document.querySelector('#usersTable')

fetch(url_user)
    .then(res => res.json())
    .then(user => {
        let temp = `
            <tr>
                            <td>${user.id}</td>
                            <td>${user.username}</td>
                            <td>${user.lastname}</td>
                            <td>${user.age}</td>
                            <td>${user.email}</td>
                            <td>${user.roles.map(role => role.name === 'ROLE_USER' ? ' USER' : ' ADMIN')}</td>
            </tr>`
        tableUser.innerHTML = temp
    })