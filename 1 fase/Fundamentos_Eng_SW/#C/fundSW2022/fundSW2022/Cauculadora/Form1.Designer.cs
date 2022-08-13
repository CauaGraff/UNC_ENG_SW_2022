namespace Cauculadora
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.txbNumero1 = new System.Windows.Forms.TextBox();
            this.txbNumero2 = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.txbResultado = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.btnSomar = new System.Windows.Forms.Button();
            this.btnSubitrari = new System.Windows.Forms.Button();
            this.btnMultiplicar = new System.Windows.Forms.Button();
            this.btnDividir = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(65, 42);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(60, 15);
            this.label1.TabIndex = 0;
            this.label1.Text = "Numero 1";
            // 
            // txbNumero1
            // 
            this.txbNumero1.Location = new System.Drawing.Point(131, 39);
            this.txbNumero1.Name = "txbNumero1";
            this.txbNumero1.Size = new System.Drawing.Size(137, 23);
            this.txbNumero1.TabIndex = 1;
            this.txbNumero1.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // txbNumero2
            // 
            this.txbNumero2.Location = new System.Drawing.Point(131, 68);
            this.txbNumero2.Name = "txbNumero2";
            this.txbNumero2.Size = new System.Drawing.Size(137, 23);
            this.txbNumero2.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(65, 71);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(60, 15);
            this.label2.TabIndex = 2;
            this.label2.Text = "Numero 2";
            // 
            // txbResultado
            // 
            this.txbResultado.Location = new System.Drawing.Point(131, 97);
            this.txbResultado.Name = "txbResultado";
            this.txbResultado.ReadOnly = true;
            this.txbResultado.Size = new System.Drawing.Size(137, 23);
            this.txbResultado.TabIndex = 5;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(65, 100);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(59, 15);
            this.label3.TabIndex = 4;
            this.label3.Text = "Resultado";
            // 
            // btnSomar
            // 
            this.btnSomar.Location = new System.Drawing.Point(328, 38);
            this.btnSomar.Name = "btnSomar";
            this.btnSomar.Size = new System.Drawing.Size(75, 23);
            this.btnSomar.TabIndex = 6;
            this.btnSomar.Text = "Somar";
            this.btnSomar.UseVisualStyleBackColor = true;
            this.btnSomar.Click += new System.EventHandler(this.btnSomar_Click);
            // 
            // btnSubitrari
            // 
            this.btnSubitrari.Location = new System.Drawing.Point(328, 67);
            this.btnSubitrari.Name = "btnSubitrari";
            this.btnSubitrari.Size = new System.Drawing.Size(75, 23);
            this.btnSubitrari.TabIndex = 7;
            this.btnSubitrari.Text = "Subitrair";
            this.btnSubitrari.UseVisualStyleBackColor = true;
            this.btnSubitrari.Click += new System.EventHandler(this.btnSubitrari_Click);
            // 
            // btnMultiplicar
            // 
            this.btnMultiplicar.Location = new System.Drawing.Point(328, 96);
            this.btnMultiplicar.Name = "btnMultiplicar";
            this.btnMultiplicar.Size = new System.Drawing.Size(75, 23);
            this.btnMultiplicar.TabIndex = 8;
            this.btnMultiplicar.Text = "Multiplicar";
            this.btnMultiplicar.UseVisualStyleBackColor = true;
            this.btnMultiplicar.Click += new System.EventHandler(this.btnMultiplicar_Click);
            // 
            // btnDividir
            // 
            this.btnDividir.Location = new System.Drawing.Point(328, 125);
            this.btnDividir.Name = "btnDividir";
            this.btnDividir.Size = new System.Drawing.Size(75, 23);
            this.btnDividir.TabIndex = 9;
            this.btnDividir.Text = "Dividir";
            this.btnDividir.UseVisualStyleBackColor = true;
            this.btnDividir.Click += new System.EventHandler(this.btnDividir_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(442, 168);
            this.Controls.Add(this.btnDividir);
            this.Controls.Add(this.btnMultiplicar);
            this.Controls.Add(this.btnSubitrari);
            this.Controls.Add(this.btnSomar);
            this.Controls.Add(this.txbResultado);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.txbNumero2);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txbNumero1);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Calculadora Fundametnos de Software";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txbNumero1;
        private System.Windows.Forms.TextBox txbNumero2;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txbResultado;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button btnSomar;
        private System.Windows.Forms.Button btnSubitrari;
        private System.Windows.Forms.Button btnMultiplicar;
        private System.Windows.Forms.Button btnDividir;
    }
}
