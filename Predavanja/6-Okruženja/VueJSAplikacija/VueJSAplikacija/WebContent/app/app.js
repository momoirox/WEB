function fixDate(students) {
	for (var s of students) {
		s.datumRodjenja = new Date(parseInt(s.datumRodjenja));
	}
	return students;
}

var app = new Vue({ 
    el: '#studenti',
    data: {
        students: null,
        title: "Primer Vue.js tehnologije na spisku studenata",
        mode: "BROWSE",
        selectedStudent: {},
        searchField: ""
    },
    mounted () {
        axios
          .get('rest/studenti/getalljson')
          .then(response => (this.students = fixDate(response.data)))
    },
    methods: {
    	selectStudent : function(student) {
    		if (this.mode == 'BROWSE') {
    			this.selectedStudent = student;
    		}    
    	},
    	editStudent : function() {
    		if (this.selectedStudent.jmbg == undefined)
    			return;
    		this.backup = [this.selectedStudent.ime, this.selectedStudent.prezime, this.selectedStudent.brojIndeksa, this.selectedStudent.datumRodjenja];
    		this.mode = 'EDIT';
    	},
    	updateStudent : function(student) {
    		var s = {jmbg:student.jmbg, ime:student.ime, prezime:student.prezime, datumRodjenja:student.datumRodjenja.getTime(), brojIndeksa:student.brojIndeksa};
    		axios
    		.post("rest/studenti/updatejson", s)
    		.then(response => toast('Student ' + student.ime + " " + student.prezime + " uspešno snimljen."));
    		this.mode = 'BROWSE';
    	},
    	cancelEditing : function() {
    		this.selectedStudent.ime = this.backup[0];
    		this.selectedStudent.prezime = this.backup[1];
    		this.selectedStudent.brojIndeksa = this.backup[2];
    		this.selectedStudent.datumRodjenja = this.backup[3];
    		this.mode = 'BROWSE';
    	}
    },
    components: {
      	vuejsDatepicker
    },
    filters: {
    	dateFormat: function (value, format) {
    		var parsed = moment(value);
    		return parsed.format(format);
    	}
   	}
});