# Documentação dos Endpoints REST

## Autenticação

### POST /auth
Realiza login do usuário.

**Request Body:**
```json
{
  "username": "string",
  "password": "string"
}
```

**Response:**
```json
{
  "access_token": "string"
}
```

---

## Usuários

### POST /users
Cria um novo usuário.

**Request Body:**
```json
{
  "username": "string",
  "password": "string",
  "role": "string" // Exemplo: "MEDICO", "ENFERMEIRO", "PACIENTE"
}
```

**Response:**  
Status 200 (OK) sem corpo.

---

## Agendamentos

### POST /appointments
Cria um novo agendamento.

**Request Body:**
```json
{
  "patient_id": 1,
  "doctor_id": 2,
  "appointment_date": "2025-09-30T10:00:00",
  "reason": "Consulta de rotina",
  "specialty": "Cardiologia",
  "location": "Sala 101"
}
```

**Response:**
```json
{
  "id": 123,
  "patient_id": 1,
  "doctor_id": 2,
  "appointment_date": "2025-09-30T10:00:00",
  "reason": "Consulta de rotina",
  "notes": "string",
  "appointment_status": "SCHEDULED",
  "specialty": "Cardiologia",
  "location": "Sala 101"
}
```

### PUT /appointments
Atualiza um agendamento.

**Request Body:**
```json
{
  "id": 123,
  "appointment_date": "2025-09-30T11:00:00",
  "notes": "Paciente pediu alteração de horário",
  "status": "RESCHEDULED"
}
```

**Response:**
```json
{
  "id": 123,
  "patient_id": 1,
  "doctor_id": 2,
  "appointment_date": "2025-09-30T11:00:00",
  "reason": "Consulta de rotina",
  "notes": "Paciente pediu alteração de horário",
  "appointment_status": "RESCHEDULED",
  "specialty": "Cardiologia",
  "location": "Sala 101"
}
```

---

