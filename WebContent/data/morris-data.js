$(function() {

	Morris.Area({
		element : 'morris-area-chart',
		data : [ {
			period : '2010 Q1',
			iphone : 2666,
			ipad : null,
			itouch : 2647
		}, {
			period : '2010 Q2',
			iphone : 2778,
			ipad : 2294,
			itouch : 2441
		}, {
			period : '2010 Q3',
			iphone : 4912,
			ipad : 1969,
			itouch : 2501
		}, {
			period : '2010 Q4',
			iphone : 3767,
			ipad : 3597,
			itouch : 5689
		} ],
		xkey : 'period',
		ykeys : [ 'iphone', 'ipad', 'itouch' ],
		labels : [ 'iPhone', 'iPad', 'iPod Touch' ],
		pointSize : 2,
		hideHover : 'auto',
		resize : true
	});

	Morris.Bar({
		element : 'morris-bar-chart',
		data : [ {
			y : '여가생활',
			a : 100,
			b : 90
		}, {
			y : '조직생활',
			a : 75,
			b : 65
		}, {
			y : '일상생활',
			a : 50,
			b : 40
		}, {
			y : '바른생활',
			a : 75,
			b : 65
		} ],
		xkey : 'y',
		ykeys : [ 'a', 'b' ],
		labels : [ '평균', '나' ],
		hideHover : 'auto',
		resize : true
	});

	Morris.Donut({
		element : 'morris-donut-chart',
		data : [ {
			label : "열정",
			value : 120
		}, {
			label : "사랑",
			value : 80
		}, {
			label : "자바",
			value : 10
		}, {
			label : "자신감",
			value : 50
		}, {
			label : "노력",
			value : 80
		} ],
		resize : true
	});

	Morris.Line({
		element : 'morris-line-chart',
		 data: [
		        { month: '2016-08', value: 20 },
		        { month: '2016-09', value: 70 },
		        { month: '2016-10', value: 10 },
		      
		      ],
		      // The name of the data record attribute that contains x-values.
		      xkey: 'month',
		      // A list of names of data record attributes that contain y-values.
		      ykeys: ['value'],
		      // Labels for the ykeys -- will be displayed when you hover over the
		      // chart.
		      labels: ['답변수'],
		resize : true
	});

});
