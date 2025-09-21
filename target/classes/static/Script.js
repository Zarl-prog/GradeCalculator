document.getElementById("gradeForm").addEventListener("submit", async function(event) {
  event.preventDefault();

  const name = document.getElementById("name").value.trim();
  const scoresInput = document.getElementById("scores").value.trim();

  if (!name || !scoresInput) {
    document.getElementById("result").innerText = "⚠️ Please fill all fields.";
    return;
  }

  const scores = scoresInput.split(",").map(s => parseInt(s.trim(), 10));

  // Basic validation
  if (scores.some(isNaN)) {
    document.getElementById("result").innerText = "⚠️ Please enter valid numbers for scores.";
    return;
  }

  try {
    const response = await fetch("/api/grades", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ name, scores })
    });

    if (!response.ok) {
      throw new Error("Server error");
    }

    const data = await response.json();

    document.getElementById("result").innerHTML = `
      <strong>${data.name}</strong><br>
      Total: ${data.total}<br>
      Average: ${data.average.toFixed(2)}<br>
      Grade: <span style="font-weight:bold">${data.grade}</span>
    `;
  } catch (error) {
    document.getElementById("result").innerText = "⚠️ Something went wrong. Try again.";
    console.error(error);
  }
});
