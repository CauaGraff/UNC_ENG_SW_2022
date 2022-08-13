using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Exercicio1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnCalcular_Click(object sender, EventArgs e)
        {
            int codigo = Convert.ToInt32(textCodigoBarras.Text);
            int[] digitos = new int[11];
            
            for (int i = 0; i <= 10; i++)
            {
                digitos[i] = ;
            }

        }
    }
}
