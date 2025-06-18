/**
 * covid_module.js
 */
let url=`https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=Mh4nGYS0C29RobpHN5u26xszko7vXCI13NiPsikxtItb4YhMUUy747mFgT%2FM5k3nFBjk4RL01GwXM%2BShAqLnLg%3D%3D`;
const defaultNum = 10;

function makeRow(center) {
	let tr = document.createElement('tr');
	for (const prop of ['id', 'centerName', 'phoneNumber']) {
		let td = document.createElement('td');
		td.innerHTML = center[prop];       // <td>1</td>
		tr.appendChild(td);
	}
	return tr;
}

export { makeRow , url } //내보내고싶은 기능들을 export