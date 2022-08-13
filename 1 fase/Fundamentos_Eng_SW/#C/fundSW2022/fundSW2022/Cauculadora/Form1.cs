using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Cauculadora
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void btnSomar_Click(object sender, EventArgs e)
        {

            int n1 = Convert.ToInt32(txbNumero1.Text);
            int n2 = Convert.ToInt32(txbNumero2.Text);
            int resul = n1 + n2;
            txbResultado.Text = resul.ToString();
        }

        private void btnSubitrari_Click(object sender, EventArgs e)
        {
            int n1 = Convert.ToInt32(txbNumero1.Text);
            int n2 = Convert.ToInt32(txbNumero2.Text);
            int resul = n1 - n2;
            txbResultado.Text = resul.ToString();
        }

        private void btnMultiplicar_Click(object sender, EventArgs e)
        {
            int n1 = Convert.ToInt32(txbNumero1.Text);
            int n2 = Convert.ToInt32(txbNumero2.Text);
            int resul = n1 * n2;
            txbResultado.Text = resul.ToString();
        }

        private void btnDividir_Click(object sender, EventArgs e)
        {
            int n1 = Convert.ToInt32(txbNumero1.Text);
            int n2 = Convert.ToInt32(txbNumero2.Text);
            int resul = n1 / n2;
            txbResultado.Text = resul.ToString();
        }
    }
}
