window.addEventListener('load', function() {
    var rows = document.querySelectorAll('table tbody tr');
    var headers = document.querySelectorAll('table thead th[data-sort]');
    var currentDirection = 'asc';

    headers.forEach(function(header) {
        header.addEventListener('click', function() {
            var property = this.getAttribute('data-sort');
            var sortedRows = sortTable(rows, property, currentDirection);
            currentDirection = currentDirection === 'asc' ? 'desc' : 'asc';
            replaceTableBody(sortedRows);
            updateHeaderIcons(this, currentDirection);
        });
    });

    function sortTable(rows, property, direction) {
        var sortedRows = Array.from(rows).sort(function(a, b) {
            var aVal = a.querySelector('td[data-property="' + property + '"]').textContent;
            var bVal = b.querySelector('td[data-property="' + property + '"]').textContent;
            if (isNaN(aVal) || isNaN(bVal)) {
                if (direction === 'asc') {
                    return aVal.localeCompare(bVal);
                } else {
                    return bVal.localeCompare(aVal);
                }
            } else {
                aVal = parseFloat(aVal);
                bVal = parseFloat(bVal);
                if (direction === 'asc') {
                    return aVal - bVal;
                } else {
                    return bVal - aVal;
                }
            }
        });
        return sortedRows;
    }


    function replaceTableBody(rows) {
        var tbody = document.querySelector('table tbody');
        rows.forEach(function(row) {
            tbody.appendChild(row);
        });
    }

    function updateHeaderIcons(header, direction) {
        var icons = header.querySelectorAll('i');
        icons.forEach(function(icon) {
            icon.classList.remove('fa-arrow-up', 'fa-arrow-down');
        });
        var iconClass = direction === 'asc' ? 'fa-arrow-up' : 'fa-arrow-down';
        header.querySelector('i[data-direction]').classList.add(iconClass);
    }
});
