using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UVnaloga
{
    public partial class temperatura : Form
    {
        public temperatura()
        {
            InitializeComponent();
            MaximizeBox = false;
            MinimizeBox = false;
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            comboBox1.Items.Add("Celzij");
            comboBox1.Items.Add("Kelvin");
            comboBox1.Items.Add("Fahrenheit");
            comboBox1.SelectedIndex = 0;

            comboBox2.Items.Add("Celzij");
            comboBox2.Items.Add("Kelvin");
            comboBox2.Items.Add("Fahrenheit");
            comboBox2.SelectedIndex = 0;
            textBox2.ReadOnly = true;
            textBox1.ReadOnly = true;
        }

        private void RoundButton14_Click(object sender, EventArgs e)
        {
            textBox1.Text = "";
            textBox2.Text = "";
        }

        private void Temperatura_Load(object sender, EventArgs e)
        {

        }

        private void RoundButton11_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + "0";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + "0";
                textBox2.Text = vrednost;
            }
        }

        private void RoundButton9_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + "1";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + "1";
                textBox2.Text = vrednost;
            }
        }

        private void RoundButton6_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + "2";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + "2";
                textBox2.Text = vrednost;
            }
        }

        private void RoundButton5_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + "3";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + "3";
                textBox2.Text = vrednost;
            }
        }

        private void RoundButton10_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + "4";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + "4";
                textBox2.Text = vrednost;
            }
        }

        private void RoundButton7_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + "5";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + "5";
                textBox2.Text = vrednost;
            }
        }

        private void RoundButton4_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + "6";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + "6";
                textBox2.Text = vrednost;
            }
        }

        private void RoundButton2_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + "7";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + "7";
                textBox2.Text = vrednost;
            }
        }

        private void RoundButton8_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + "8";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + "8";
                textBox2.Text = vrednost;
            }
        }

        private void RoundButton3_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + "9";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + "9";
                textBox2.Text = vrednost;
            }
        }

        private void RoundButton1_Click(object sender, EventArgs e)
        {
            Form1 m = new Form1();
            m.Show();
            this.Hide();
        }

        private void PuscicaGumb_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 1)
            {
                puscicaGumb.ImageIndex = 0;
            }
            else
            {
                puscicaGumb.ImageIndex = 1;
            }
        }

        private void RoundButton15_Click(object sender, EventArgs e)
        {

            Dictionary<string, Double> vrednosti = new Dictionary<string, Double>();
            vrednosti.Add("Celzij-Celzij",1);
            vrednosti.Add("Celzij-Kelvin", 273.15);
            vrednosti.Add("Celzij-Fahrenheit", 32);

            vrednosti.Add("Kelvin-Celzij", 1);
            vrednosti.Add("Kelvin-Kelvin", 273.15);
            vrednosti.Add("Kelvin-Fahrenheit", 32);

            vrednosti.Add("Fahrenheit-Celzij", 1);
            vrednosti.Add("Fahrenheit-Kelvin", 273.15);
            vrednosti.Add("Fahrenheit-Fahrenheit", 32);

            int smer = puscicaGumb.ImageIndex;

            if (smer == 0)
            {
                String skupaj = comboBox1.Text + "-" + comboBox2.Text;
                
                Double vnos = Convert.ToDouble(textBox1.Text);
                Double rez;
                if(skupaj == "Celzij-Kelvin")
                {
                    rez = vnos + 273.15;
                    textBox2.Text = rez.ToString();
                }else if (skupaj == "Celzij-Fahrenheit")
                {
                    rez = (vnos * 9 / 5) + 32;
                    textBox2.Text = rez.ToString();
                }else if(skupaj == "Kelvin-Celzij")
                {
                    rez = vnos - 273.15;
                    textBox2.Text = rez.ToString();
                }else if (skupaj == "Kelvin-Fahrenheit")
                {
                    rez = ((vnos - 273.15)* 9/5) +32 ;
                    textBox2.Text = rez.ToString();
                }else if(skupaj == "Fahrenheit-Celzij")
                {
                    rez = (vnos - 32) * 5/9;
                    textBox2.Text = rez.ToString();
                }else if (skupaj == "Fahrenheit-Kelvin")
                {
                    rez = ((vnos - 32) * 5 / 9) + 273.15;
                    textBox2.Text = rez.ToString();
                }
                else
                {
                    textBox2.Text = vnos.ToString();
                }

            }
            else
            {
                String skupaj = comboBox1.Text + "-" + comboBox2.Text;

                Double vnos = Convert.ToDouble(textBox2.Text);
                Double rez;
                if (skupaj == "Celzij-Kelvin")
                {
                    rez = vnos + 273.15;
                    textBox1.Text = rez.ToString();
                }
                else if (skupaj == "Celzij-Fahrenheit")
                {
                    rez = (vnos * 9 / 5) + 32;
                    textBox1.Text = rez.ToString();
                }
                else if (skupaj == "Kelvin-Celzij")
                {
                    rez = vnos - 273.15;
                    textBox1.Text = rez.ToString();
                }
                else if (skupaj == "Kelvin-Fahrenheit")
                {
                    rez = ((vnos - 273.15) * 9 / 5) + 32;
                    textBox1.Text = rez.ToString();
                }
                else if (skupaj == "Fahrenheit-Celzij")
                {
                    rez = (vnos - 32) * 5 / 9;
                    textBox1.Text = rez.ToString();
                }
                else if (skupaj == "Fahrenheit-Kelvin")
                {
                    rez = ((vnos - 32) * 5 / 9) + 273.15;
                    textBox1.Text = rez.ToString();
                }
                else
                {
                    textBox1.Text = vnos.ToString();
                }
            }
        }

        private void RoundButton12_Click(object sender, EventArgs e)
        {

        }

        private void RoundButton16_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                vrednost = vrednost + ",";
                textBox1.Text = vrednost;
            }
            else
            {
                String vrednost = textBox2.Text;

                vrednost = vrednost + ",";
                textBox2.Text = vrednost;
            }
        }

        private void RoundButton12_Click_1(object sender, EventArgs e)
        {
            

            int smer = puscicaGumb.ImageIndex;

            if (smer == 0)
            {
                String skupaj = comboBox1.Text + "-" + comboBox2.Text;
                info nov = new info(skupaj, "temperatura");
                nov.Show();
            }
            else
            {
                String skupaj = comboBox2.Text + "-" + comboBox1.Text;
                info nov = new info(skupaj, "temperatura");
                nov.Show();
            }
           
            this.Hide();
        }

        private void Button2_Click(object sender, EventArgs e)
        {
            Form1 m = new Form1();
            m.Show();
            this.Hide();
        }

        private void TextBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void RoundButton13_Click(object sender, EventArgs e)
        {
            if (puscicaGumb.ImageIndex == 0)
            {
                String vrednost = textBox1.Text;

                if (vrednost != "")
                {
                   vrednost = vrednost.Remove(vrednost.Length - 1);
                    if (vrednost.EndsWith(","))
                    {
                        vrednost = vrednost.Remove(vrednost.Length - 1);
                    }
                        textBox1.Text = vrednost; 
                }

                
            }
            else
            {
                String vrednost = textBox2.Text;

                if(vrednost != "")
                {
                    vrednost = vrednost.Remove(vrednost.Length - 1);
                    if (vrednost.EndsWith(","))
                    {
                        vrednost = vrednost.Remove(vrednost.Length - 1);
                    }
                    textBox2.Text = vrednost;
                }

                
            }
        }

        private void Button1_Click(object sender, EventArgs e)
        {

            int smer = puscicaGumb.ImageIndex;

            if (smer == 0)
            {
                String skupaj = comboBox1.Text + "-" + comboBox2.Text;
                info nov = new info(skupaj, "temperatura");
                nov.Show();
            }
            else
            {
                String skupaj = comboBox2.Text + "-" + comboBox1.Text;
                info nov = new info(skupaj, "temperatura");
                nov.Show();
            }

            this.Hide();
        }
    }
}
