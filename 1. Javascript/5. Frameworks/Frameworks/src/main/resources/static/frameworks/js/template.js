const course = {
    "name": "DAT152",
    "lecturer": "Bjarte Wang-Kileng",
    "start": new Date(2024, 7, 20)
};

const locale = "en-GB";
const startday = course.start.toLocaleDateString(locale, { weekday: 'long' });
const startmonth = course.start.toLocaleDateString(locale, { month: 'long' });

const infoString = `Course info for ${course.name}:
First lecture on ${startday}, ${startmonth} ${course.start.getDate()}.
Lecturer is ${course.lecturer}.`;

console.log(infoString);
