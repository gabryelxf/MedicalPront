# MedicalPront

Repositório do mini-projeto de prontuario médico.

API utilizando java - 8. JDBC e servlets.

Método POST. Request JSON. cpfPaciente.

API retorna um histórico do paciente em formato JSON. Prontuários, anamneses, exames, prescricoes, atestados, medicos e cid's.


Exemplo de chamada: http://localhost:8080/MedicalPront/pacienteDados

{
	"cpfPaciente":"57241790081"
}

Exemplo de saida: (Falta formatar para UTF-8)

{
	"cpfPaciente": "57241790081",
	"nomePaciente": "Pedro",
	"emailPaciente": "pedro@pedrinho.com",
	"dataNascimentoPaciente": "ago 4, 1997",
	"telefonePaciente": "61983035663",
	"prontuarios": [
		{
			"idProntuario": 1,
			"exames": [
				{
					"idExame": 1,
					"descricaoExame": "Exame Sangue",
					"obsExame": "Hemograma",
					"dataExame": "jul 3, 2022"
				},
				{
					"idExame": 2,
					"descricaoExame": "Exame Imagem",
					"obsExame": "Raio X",
					"dataExame": "fev 3, 2022"
				},
				{
					"idExame": 5,
					"descricaoExame": "Exame visual-t�til",
					"obsExame": "Pr�stata",
					"dataExame": "jul 3, 2022"
				}
			],
			"anamneses": [
				{
					"idAnamnese": 1,
					"descricaoBasicaAnamnese": "Anamnese Basica",
					"descricaoCompletaAnamnese": "Cliente se queixou de dor clavicular",
					"prescricoes": [],
					"atestados": [],
					"cid": [
						{
							"id": "M759",
							"descricao": "Les�o n�o especificada do ombro"
						}
					],
					"medico": {
						"crmMedico": "CRM/SP123456",
						"nomeMedico": "Vitor Pionorio",
						"dataNascimentoMedico": "out 22, 1997",
						"naturalidadeMedico": "DF"
					}
				},
				{
					"idAnamnese": 2,
					"descricaoBasicaAnamnese": "Anamnese Basica 2",
					"descricaoCompletaAnamnese": "Cliente se queixou de dor no delt�ide direito",
					"prescricoes": [],
					"atestados": [],
					"cid": [
						{
							"id": "M751",
							"descricao": "S�ndrome do manguito rotador"
						},
						{
							"id": "M753",
							"descricao": "Tendinite calcificante do ombro"
						}
					],
					"medico": {
						"crmMedico": "CRM/SP123456",
						"nomeMedico": "Vitor Pionorio",
						"dataNascimentoMedico": "out 22, 1997",
						"naturalidadeMedico": "DF"
					}
				}
			],
			"descricaoProntuario": "Pront Pedro 1"
		}
	]
}
